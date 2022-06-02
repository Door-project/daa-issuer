package eu.door.daaissuer.model;

public class GetIssuerChallengeReq {
    private String issreg;

    public GetIssuerChallengeReq() {
    }

    public GetIssuerChallengeReq(String issreg) {
        this.issreg = issreg;
    }

    public String getIssreg() {
        return issreg;
    }

    public void setIssreg(String issreg) {
        this.issreg = issreg;
    }
}
