package eu.door.daaissuer.model;

import com.google.gson.Gson;

public class NotificationNote {
    private String signedTpmNonce;

    public NotificationNote(DaaRegister daaRegister) {
        this.signedTpmNonce = new Gson().toJson(daaRegister.getSignedTpmNonce());
    }

    public String getSignedTpmNonce() {
        return signedTpmNonce;
    }

    public void setSignedTpmNonce(String signedTpmNonce) {
        this.signedTpmNonce = signedTpmNonce;
    }
}
