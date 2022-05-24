package eu.door.daaissuer.payload;


import java.io.Serializable;

public class TestDto implements Serializable {

    private String message;

    public TestDto(){
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
