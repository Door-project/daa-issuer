package eu.door.daaissuer.model;

public class IssueEvidenceReq {
    private String daaHandle;
    private byte[] signature;
    private IssueObject issueObject;

    public IssueEvidenceReq(){}

    public IssueEvidenceReq(String daaHandle, byte[] signature, IssueObject issueObject) {
        this.daaHandle = daaHandle;
        this.signature = signature;
        this.issueObject = issueObject;
    }

    public String getDaaHandle() {
        return daaHandle;
    }

    public void setDaaHandle(String daaHandle) {
        this.daaHandle = daaHandle;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public IssueObject getIssueObject() {
        return issueObject;
    }

    public void setIssueObject(IssueObject issueObject) {
        this.issueObject = issueObject;
    }
}
