package eu.door.daaissuer.model;

public class NotificationNote {
    private byte[] signedTpmNonce;
    private byte[] tpmNonce;
    private String token;

    public NotificationNote(DaaRegister daaRegister) {
        this.signedTpmNonce = daaRegister.getSignedTpmNonce();
        this.tpmNonce = daaRegister.getTpmNonce();
        this.token = daaRegister.getRegnObject()
                .getToken();
    }

    public byte[] getSignedTpmNonce() {
        return signedTpmNonce;
    }

    public void setSignedTpmNonce(byte[] signedTpmNonce) {
        this.signedTpmNonce = signedTpmNonce;
    }

    public byte[] getTpmNonce() {
        return tpmNonce;
    }

    public void setTpmNonce(byte[] tpmNonce) {
        this.tpmNonce = tpmNonce;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
