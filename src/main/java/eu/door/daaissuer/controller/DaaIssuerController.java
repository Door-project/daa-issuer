package eu.door.daaissuer.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.gson.Gson;
import eu.door.daaissuer.model.DaaRegister;
import eu.door.daaissuer.model.DaaUserHandle;
import eu.door.daaissuer.model.TestDto;
import eu.door.daaissuer.service.DaaIssuerService;
import eu.door.daaissuer.service.FirebaseMessagingService;
import eu.door.daaissuer.service.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DaaIssuerController {

    private Logger logger = LoggerFactory.getLogger(DaaIssuerController.class);


    @Autowired
    private DaaIssuerService service;

    private final FirebaseMessagingService firebaseService;


    public DaaIssuerController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(final @RequestBody TestDto testDto) {

        try {
            return ResponseEntity.ok(
                    service.test(testDto)
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error");
        }
    }

    private int notificationCount = 0;
    private DaaUserHandle daaUserHandle = null;

    @RequestMapping("/send-notification")
    @ResponseBody
    public ResponseEntity<?> sendNotification(@RequestBody Note note,
                                              @RequestParam String token)
            throws FirebaseMessagingException, InterruptedException {

        logger.info("sendNotification");

        int n = notificationCount;

        String response = firebaseService.sendNotification(note, token);
        logger.info("response: " + response);

        while(n == notificationCount){
            TimeUnit.MILLISECONDS.sleep(100);
        }

        return ResponseEntity.ok(daaUserHandle);
    }


    // set request timeout 5 seconds
    private static final int TIMEOUT = 5;

    @RequestMapping("/daaRegister")
    @ResponseBody
    public ResponseEntity<?> daaRegister(@RequestBody DaaRegister daaRegister )
            throws FirebaseMessagingException, InterruptedException {

        logger.info("daaRegister");

        int n = notificationCount;

        String token = daaRegister.getRegnObject().getToken();
        Note note = new Note();
        note.setSubject("DAA Protocol Exchange");

        //integration with core library: Notification data tbd

        Gson gson = new Gson();
        Map data = gson.fromJson(
                gson.toJson(daaRegister.getRegnObject()),
                Map.class
        );
        note.setData(data);

        String response = firebaseService.sendNotification(note, token);
        logger.info("response: " + response);

        int milliseconds = 0;
        while(n == notificationCount){
            TimeUnit.MILLISECONDS.sleep(100);
            milliseconds += 100;
            if(milliseconds >= TIMEOUT*1000) {
                return ResponseEntity.status(500).body("Failed to get response from the mobile.");
            }
        }

        return ResponseEntity.ok(daaUserHandle);
    }

    @RequestMapping("/daaUserHandle")
    @ResponseBody
    public ResponseEntity<?> daaUserHandle( @RequestBody DaaUserHandle daaUserHandle ) {

        logger.info("daaUserHandle");

        this.daaUserHandle = daaUserHandle;
        notificationCount++;

        return ResponseEntity.ok("OK");
    }

}
