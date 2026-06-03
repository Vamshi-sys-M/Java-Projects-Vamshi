package Projects.TicTacToe.exception;

public class GameDrawException extends RuntimeException {
    public GameDrawException() {
    }

    public GameDrawException(String message) {
        super(message);
    }

    public GameDrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameDrawException(Throwable cause) {
        super(cause);
    }

    public GameDrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
