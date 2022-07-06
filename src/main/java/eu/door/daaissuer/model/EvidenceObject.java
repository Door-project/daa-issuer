package eu.door.daaissuer.model;

public class EvidenceObject {
    private String daaSignature;
    private byte[] nonce;

    public EvidenceObject(){}

    public EvidenceObject(String daaSignature, byte[] nonce) {
        this.daaSignature = daaSignature;
        this.nonce = nonce;
    }

    public String getDaaSignature() {
        return daaSignature;
    }

    public void setDaaSignature(String daaSignature) {
        this.daaSignature = daaSignature;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] nonce) {
        this.nonce = nonce;
    }
}
