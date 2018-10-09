package edu.etc.by.kickstart.exception;

public class BuilderException extends Exception {
    private static final long serialVersionUID = 4102978137327718684L;

    public BuilderException() {
        super();
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderException(Throwable cause) {
        super(cause);
    }
}
