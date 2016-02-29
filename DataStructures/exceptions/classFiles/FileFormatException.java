package exceptions.classFiles;

/**
 * Created by David on 1/11/2016.
 */
public class FileFormatException extends Exception{

    public FileFormatException() {

    }

    public FileFormatException(String arg0) {
        super(arg0);
    }

    public FileFormatException(Throwable cause) {
        super(cause);
    }

    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileFormatException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
