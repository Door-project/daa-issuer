package eu.door.daaissuer.model;

public class getIssuerChallengeRes {
    private String challenge;

    public getIssuerChallengeRes() {
    }

    public getIssuerChallengeRes(String challenge) {
        this.challenge = challenge;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
}
