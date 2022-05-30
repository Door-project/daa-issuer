package eu.door.daaissuer.model;

import org.apache.commons.codec.binary.Base64;

public class IssueEvidenceReq {
    private String daaHandle;
    private String signature;
    private IssueObject issueObject;

    public IssueEvidenceReq(){}

    public IssueEvidenceReq(String daaHandle, byte[] signature, IssueObject issueObject) {
        this.daaHandle = daaHandle;
        this.signature = Base64.encodeBase64String(signature);
        this.issueObject = issueObject;
    }

    public String getDaaHandle() {
        return daaHandle;
    }

    public void setDaaHandle(String daaHandle) {
        this.daaHandle = daaHandle;
    }

    public byte[] getSignature() {
        return Base64.decodeBase64(signature);
    }

    public void setSignature(byte[] signature) {
        this.signature = Base64.encodeBase64String(signature);
    }

    public IssueObject getIssueObject() {
        return issueObject;
    }

    public void setIssueObject(IssueObject issueObject) {
        this.issueObject = issueObject;
    }
}
