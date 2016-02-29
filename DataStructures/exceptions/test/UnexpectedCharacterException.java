package exceptions.test;

/**
 * Created by David on 1/27/2016.
 */
public class UnexpectedCharacterException extends Exception {
    public UnexpectedCharacterException() {

    }

    public UnexpectedCharacterException(String arg0) {
        super(arg0);
    }

    public UnexpectedCharacterException(Throwable cause) {
        super(cause);
    }

    public UnexpectedCharacterException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedCharacterException(String message, Throwable cause,
                                    boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
