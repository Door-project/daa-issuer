package eu.door.daaissuer.model;

public class IssueObject {
    private byte[] daaCRD;
    private byte[] nonce;
    private byte[] signature;
    private String id;

    public IssueObject(){}

    public IssueObject(byte[] daaCRD, byte[] nonce, byte[] signature, String id) {
        this.daaCRD = daaCRD;
        this.nonce = nonce;
        this.signature = signature;
        this.id = id;
    }

    public byte[] getDaaCRD() {
        return daaCRD;
    }

    public void setDaaCRD(byte[] daaCRD) {
        this.daaCRD = daaCRD;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
