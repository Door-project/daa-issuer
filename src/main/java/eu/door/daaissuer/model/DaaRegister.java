package eu.door.daaissuer.model;

public class DaaRegister {
    private byte[] signedTpmNonce;
    private byte[] P_EK;
    private byte[] tpmNonce;
    private String token;

    public DaaRegister() {
    }

    public DaaRegister(byte[] signedTpmNonce, byte[] p_EK, byte[] tpmNonce, String token) {
        this.signedTpmNonce = signedTpmNonce;
        P_EK = p_EK;
        this.tpmNonce = tpmNonce;
        this.token = token;
    }

    public byte[] getSignedTpmNonce() {
        return signedTpmNonce;
    }

    public void setSignedTpmNonce(byte[] signedTpmNonce) {
        this.signedTpmNonce = signedTpmNonce;
    }

    public byte[] getP_EK() {
        return P_EK;
    }

    public void setP_EK(byte[] p_EK) {
        P_EK = p_EK;
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
