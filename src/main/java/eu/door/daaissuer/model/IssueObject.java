package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class IssueObject {
    private String daaSignature;
    private String tpmNonce;
    private String signedTpmNonce;

    public IssueObject(){}

    public IssueObject(String daaSignature, byte[] tpmNonce, byte[] signedTpmNonce) {
        this.daaSignature = daaSignature;
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
        this.signedTpmNonce = Base64.encodeBase64String(signedTpmNonce);
    }

    public String getDaaSignature() {
        return daaSignature;
    }

    public void setDaaSignature(String daaSignature) {
        this.daaSignature = daaSignature;
    }

    public byte[] getTpmNonce() {
        return Base64.decodeBase64(tpmNonce);
    }

    public void setTpmNonce(byte[] tpmNonce) {
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
    }

    public byte[] getSignedTpmNonce() {
        return Base64.decodeBase64(signedTpmNonce);
    }

    public void setSignedTpmNonce(byte[] signedTpmNonce) {
        this.signedTpmNonce = Base64.encodeBase64String(signedTpmNonce);
    }
}
