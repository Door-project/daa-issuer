package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class IssueEvidenceReq {
    private String daaSignature;
    private String issueObject;
    private String signature;

    public IssueEvidenceReq(){}

    public IssueEvidenceReq(String daaSignature, byte[] issueObject, byte[] signature) {
        this.daaSignature = daaSignature;
        this.issueObject = Base64.encodeBase64String(issueObject);
        this.signature = Base64.encodeBase64String(signature);
    }

    public String getDaaSignature() {
        return daaSignature;
    }

    public void setDaaSignature(String daaSignature) {
        this.daaSignature = daaSignature;
    }

    public byte[] getIssueObject() {
        return Base64.decodeBase64(issueObject);
    }

    public void setIssueObject(byte[] issueObject) {
        this.issueObject = Base64.encodeBase64String(issueObject);
    }

    public byte[] getSignature() {
        return Base64.decodeBase64(signature);
    }

    public void setSignature(byte[] signature) {
        this.signature = Base64.encodeBase64String(signature);
    }
}
