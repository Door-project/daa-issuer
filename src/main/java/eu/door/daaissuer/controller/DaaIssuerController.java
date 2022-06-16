package eu.door.daaissuer.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.gson.Gson;
import eu.door.daaissuer.logging.LogOutputStream;
import eu.door.daaissuer.logging.LoggingOutputStream;
import eu.door.daaissuer.model.*;
import eu.door.daaissuer.service.FirebaseMessagingService;
import eu.door.daaissuer.service.Note;
import jni.DAAInterface;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DaaIssuerController {

    private Logger logger;


    private final FirebaseMessagingService firebaseService;

    private final DAAInterface daa = new DAAInterface();


    public DaaIssuerController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;

        logger = LogManager.getLogger(DaaIssuerController.class);
        System.setErr(new PrintStream(new LoggingOutputStream(logger, Level.ERROR)));
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

        daa.registerWalletPK(getIssuerChallengeReq.getWalletPublicKey().getBytes());
        String challenge = daa.getIssuerChallenge(getIssuerChallengeReq.getIssreg());

        return ResponseEntity.ok(
                new GetIssuerChallengeRes("challenge")
        );
    }

    @RequestMapping("/getFullCredential")
    @ResponseBody
    public ResponseEntity<?> getFullCredential( @RequestBody GetFullCredentialReq getFullCredentialReq ) {

        logger.info("getFullCredential");

        String fcre = daa.sendChallengeResponse(getFullCredentialReq.getChallengeResponse());

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
        System.out.println("sout: issueEvidence");

        //integration with core library

        return ResponseEntity.ok(
                new IssueEvidenceResponse(
                        issueEvidenceReq.getDaaSignature(),
                        issueEvidenceReq.getNonce())
        );
    }





}
