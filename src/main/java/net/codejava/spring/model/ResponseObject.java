package net.codejava.spring.model;

public class ResponseObject {

	private boolean success;
    private String message;
    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
    public ResponseObject(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }
}
