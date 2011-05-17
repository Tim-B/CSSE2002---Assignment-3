package models;

/** This exception is thrown when the user enters invalid input.
 */
public class UserException extends StudentsLifeException {

    /**
     * 
     * @param message
     */
    public UserException(String message) {
		super(message);
	}

        /**
         * 
         * @param message
         * @param ex
         */
        public UserException(String message, Throwable ex) {
		super(message, ex);
	}
}
