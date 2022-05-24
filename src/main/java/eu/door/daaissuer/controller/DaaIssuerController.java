package eu.door.daaissuer.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import eu.door.daaissuer.payload.DaaUserHandle;
import eu.door.daaissuer.payload.TestDto;
import eu.door.daaissuer.service.DaaIssuerService;
import eu.door.daaissuer.service.FirebaseMessagingService;
import eu.door.daaissuer.service.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/daaUserHandle")
    @ResponseBody
    public ResponseEntity<?> daaUserHandle( @RequestBody DaaUserHandle daaUserHandle ) {

        logger.info("daaUserHandle");

        this.daaUserHandle = daaUserHandle;
        notificationCount++;

        return ResponseEntity.ok("OK");
    }

}
