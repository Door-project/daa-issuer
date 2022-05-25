package eu.door.daaissuer.model;

public class DaaRegister {
    private byte[] signature;
    private RegnObject regnObject;

    public DaaRegister(byte[] signature, RegnObject regnObject) {
        this.signature = signature;
        this.regnObject = regnObject;
    }
    public DaaRegister() {
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public RegnObject getRegnObject() {
        return regnObject;
    }

    public void setRegnObject(RegnObject regnObject) {
        this.regnObject = regnObject;
    }
}
