package eu.door.daaissuer.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.gson.Gson;
import eu.door.daaissuer.model.*;
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


    private final FirebaseMessagingService firebaseService;

    public DaaIssuerController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }


    // set request timeout 10 seconds
    private static final int TIMEOUT = 10;
    private int registerCount = 0;

    @RequestMapping("/daaRegister")
    @ResponseBody
    public ResponseEntity<?> daaRegister(@RequestBody DaaRegister daaRegister )
            throws FirebaseMessagingException, InterruptedException {

        logger.info("daaRegister");

        int n = registerCount;

        String token = daaRegister.getRegnObject().getToken();
        Note note = new Note();
        note.setSubject("DAA Protocol Exchange");

        Gson gson = new Gson();
        Map data = gson.fromJson(
                gson.toJson(new NotificationNote(daaRegister)),
                Map.class
        );
        note.setData(data);

        String response = firebaseService.sendNotification(note, token);
        logger.info("response: " + response);

        int milliseconds = 0;
        while(n == registerCount){
            TimeUnit.MILLISECONDS.sleep(100);
            milliseconds += 100;
            if(milliseconds >= TIMEOUT*1000) {
                return ResponseEntity.status(500).body("Timeout: Failed to get response from the mobile.");
            }
        }

        return ResponseEntity.ok(daaRegister.getRegnObject().getToken());
    }

    @RequestMapping("/getIssuerChallenge")
    @ResponseBody
    public ResponseEntity<?> getIssuerChallenge( @RequestBody GetIssuerChallengeReq getIssuerChallengeReq ) {

        logger.info("getIssuerChallenge");

        //String challenge = daaInterface.getIssuerChallenge(issreg);

        return ResponseEntity.ok(
                new GetIssuerChallengeRes("challenge")
        );
    }

    @RequestMapping("/getFullCredential")
    @ResponseBody
    public ResponseEntity<?> getFullCredential( @RequestBody GetFullCredentialReq getFullCredentialReq ) {

        logger.info("getFullCredential");

        // String fcre = daaInterface.sendChallengeResponse(challengeResponse);

        return ResponseEntity.ok(
                new GetFullCredentialRes("fcre")
        );
    }

    @RequestMapping("/enabledFullCredential")
    @ResponseBody
    public ResponseEntity<?> enabledFullCredential( @RequestBody EnabledFullCredentialReq enabledFullCredentialReq ) {

        logger.info("enabledFullCredential");

        registerCount++;

        return ResponseEntity.ok("OK");
    }

    @RequestMapping("/issueEvidence")
    @ResponseBody
    public ResponseEntity<?> issueEvidence(@RequestBody IssueEvidenceReq issueEvidenceReq ) {
        logger.info("issueEvidence");

        //integration with core library

        return ResponseEntity.ok(issueEvidenceReq.getDaaSignature());
    }





}
