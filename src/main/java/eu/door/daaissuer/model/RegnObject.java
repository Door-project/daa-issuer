package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class RegnObject {
    private String P_EK;
    private String tpmNonce;
    private String token;

    public RegnObject(byte[] p_EK, byte[] tpmNonce, String token) {
        P_EK = Base64.encodeBase64String(p_EK);
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
        this.token = token;
    }

    public RegnObject() {
    }

    public byte[] getP_EK() {
        return Base64.decodeBase64(P_EK);
    }

    public void setP_EK(byte[] p_EK) {
        P_EK = Base64.encodeBase64String(p_EK);
    }

    public byte[] getTpmNonce() {
        return Base64.decodeBase64(tpmNonce);
    }

    public void setTpmNonce(byte[] tpmNonce) {
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
