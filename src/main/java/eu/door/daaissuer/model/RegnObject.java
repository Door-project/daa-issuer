package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class RegnObject {
    private byte[] P_EK;
    private byte[] tpmNonce;
    private String token;

    public RegnObject(byte[] p_EK, byte[] tpmNonce, String token) {
        P_EK = p_EK;
        this.tpmNonce = tpmNonce;
        this.token = token;
    }

    public RegnObject() {
    }

    public byte[] getP_EK() {
        return P_EK;
    }

    public void setP_EK(byte[] p_EK) {
        P_EK = p_EK;
    }

    public byte[] getTpmNonce() {
        return Base64.decodeBase64(tpmNonce);
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
