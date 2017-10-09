package exception;

public class DBExceptionRT extends RuntimeException {
    public DBExceptionRT(String message, Throwable cause) {
        super(message, cause);
    }
}
