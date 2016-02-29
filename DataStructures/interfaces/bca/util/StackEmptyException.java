package interfaces.bca.util;

/**
 * Created by David on 2/3/2016.
 */
public class StackEmptyException extends RuntimeException{
    public StackEmptyException() {

    }

    public StackEmptyException(String arg0) {
        super(arg0);
    }

    public StackEmptyException(Throwable cause) {
        super(cause);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackEmptyException(String message, Throwable cause,
                                        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
