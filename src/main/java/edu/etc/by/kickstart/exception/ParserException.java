package edu.etc.by.kickstart.exception;

public class ParserException extends Exception {
    private static final long serialVersionUID = -7804770342225998969L;

    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }
}
