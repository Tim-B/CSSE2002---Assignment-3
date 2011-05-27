package models;

/**
 * An invalid game action has been requested.
 */
public class InvalidActionException extends RuntimeException {

    /**
     *
     * @param message the message to be passed to the exception
     */
    public InvalidActionException(String message) {

        super(message);

    }

    /**
     *
     * @param message the message being passed to the exception
     * @param cause the throwable cause of the exception
     */
    public InvalidActionException(String message, Throwable cause) {

        super(message, cause);

    }
}



