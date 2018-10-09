package edu.etc.by.kickstart.exception;

public class ReceiverException extends Exception {

    private static final long serialVersionUID = 6661068053221398081L;

    public ReceiverException() {
        super();
    }

    public ReceiverException(String message) {
        super(message);
    }

    public ReceiverException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReceiverException(Throwable cause) {
        super(cause);
    }
}
