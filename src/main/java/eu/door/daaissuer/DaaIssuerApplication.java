package eu.door.daaissuer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import jni.DAAInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class DaaIssuerApplication {

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		GoogleCredentials googleCredentials = GoogleCredentials
				.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
		FirebaseOptions firebaseOptions = FirebaseOptions
				.builder()
				.setCredentials(googleCredentials)
				.build();
		FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
		return FirebaseMessaging.getInstance(app);
	}

	private static void registerIssuerPrivateKey() {
		DAAInterface daa = new DAAInterface();

		String ik_priv = "-----BEGIN EC PRIVATE KEY-----\n" +
				"MHcCAQEEIF8Cx/viWSyi0gCp/OcbMFJrbKmzO2PwlqA/RNtv9UMZoAoGCCqGSM49\n" +
				"AwEHoUQDQgAE4CwPPzL9DS6n2zcDsV1hOadgL25QhTF3PuomKkE3/ET4GcPMTkYi\n" +
				"8zd2IIUVI/FwY+sWTyHhCxrHkfXKksSAmA==\n" +
				"-----END EC PRIVATE KEY-----\n";

		byte[] issuerPriv = ik_priv.getBytes();

		daa.registerIssuer_priv(issuerPriv);
	}

	public static void main(String[] args) {
		registerIssuerPrivateKey();
		SpringApplication.run(DaaIssuerApplication.class, args);

	}
}
