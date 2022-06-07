package eu.door.daaissuer.model;

public class IssueEvidenceReq {
    private String daaSignature;
    private byte[] nonce;
    private byte[] signedNonce;

    public IssueEvidenceReq(){}

    public IssueEvidenceReq(String daaSignature, byte[] nonce, byte[] signedNonce) {
        this.daaSignature = daaSignature;
        this.nonce = nonce;
        this.signedNonce = signedNonce;
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

    public byte[] getSignedNonce() {
        return signedNonce;
    }

    public void setSignedNonce(byte[] signedNonce) {
        this.signedNonce = signedNonce;
    }
}
