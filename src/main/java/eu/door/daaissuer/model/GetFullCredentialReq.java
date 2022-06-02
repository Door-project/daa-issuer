package eu.door.daaissuer.model;

public class GetFullCredentialReq {
    private String challengeResponse;

    public GetFullCredentialReq() {
    }

    public GetFullCredentialReq(String challengeResponse) {
        this.challengeResponse = challengeResponse;
    }

    public String getChallengeResponse() {
        return challengeResponse;
    }

    public void setChallengeResponse(String challengeResponse) {
        this.challengeResponse = challengeResponse;
    }
}
