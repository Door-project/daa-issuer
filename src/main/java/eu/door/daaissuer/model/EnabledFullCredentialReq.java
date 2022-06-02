package eu.door.daaissuer.model;

public class EnabledFullCredentialReq {
    private String message;

    public EnabledFullCredentialReq() {
    }

    public EnabledFullCredentialReq(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
