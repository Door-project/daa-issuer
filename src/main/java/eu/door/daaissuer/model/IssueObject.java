package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class IssueObject {
    private String daaCRD;
    private String nonce;
    private String signature;
    private String id;

    public IssueObject(){}

    public IssueObject(byte[] daaCRD, byte[] nonce, byte[] signature, String id) {
        this.daaCRD = Base64.encodeBase64String(daaCRD);
        this.nonce = Base64.encodeBase64String(nonce);
        this.signature = Base64.encodeBase64String(signature);
        this.id = id;
    }

    public byte[] getDaaCRD() {
        return Base64.decodeBase64(daaCRD);
    }

    public void setDaaCRD(byte[] daaCRD) {
        this.daaCRD = Base64.encodeBase64String(daaCRD);
    }

    public byte[] getNonce() {
        return Base64.decodeBase64(nonce);
    }

    public void setNonce(byte[] nonce) {
        this.nonce = Base64.encodeBase64String(nonce);
    }

    public byte[] getSignature() {
        return Base64.decodeBase64(signature);
    }

    public void setSignature(byte[] signature) {
        this.signature = Base64.encodeBase64String(signature);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
