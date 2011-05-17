package models;

/**
 * An invalid game action has been requested.
 */
public class InvalidActionException extends RuntimeException {

    /**
     * 
     * @param message
     */
    public InvalidActionException(String message) {
		super(message);
	}

        /**
         * 
         * @param message
         * @param cause
         */
        public InvalidActionException(String message, Throwable cause) {
		super(message, cause);
	}
}
