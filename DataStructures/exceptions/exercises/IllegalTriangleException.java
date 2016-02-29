package exceptions.exercises;

/**
 * Created by David on 1/19/2016.
 */
public class IllegalTriangleException extends RuntimeException {
    public IllegalTriangleException() {

    }

    public IllegalTriangleException(String arg0) {
        super(arg0);
    }

    public IllegalTriangleException(Throwable cause) {
        super(cause);
    }

    public IllegalTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTriangleException(String message, Throwable cause,
                                    boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
