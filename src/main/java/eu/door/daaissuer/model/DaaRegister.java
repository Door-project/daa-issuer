package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class DaaRegister {
    private String signedTpmNonce;
    private String tpmNonce;
    private RegnObject regnObject;

    public DaaRegister() {
    }

    public DaaRegister(byte[] signedTpmNonce, byte[] tpmNonce, RegnObject regnObject) {
        this.signedTpmNonce = Base64.encodeBase64String(signedTpmNonce);
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
        this.regnObject = regnObject;
    }

    public byte[] getSignedTpmNonce() {
        return Base64.decodeBase64(signedTpmNonce);
    }

    public void setSignedTpmNonce(byte[] signedTpmNonce) {
        this.signedTpmNonce = Base64.encodeBase64String(signedTpmNonce);
    }

    public byte[] getTpmNonce() {
        return Base64.decodeBase64(tpmNonce);
    }

    public void setTpmNonce(byte[] tpmNonce) {
        this.tpmNonce = Base64.encodeBase64String(tpmNonce);
    }

    public RegnObject getRegnObject() {
        return regnObject;
    }

    public void setRegnObject(RegnObject regnObject) {
        this.regnObject = regnObject;
    }
}
