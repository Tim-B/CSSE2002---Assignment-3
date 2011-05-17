package models;

/**
 * This exception is thrown when there is a problem with the format
 * of an serialized card deck.
 */
public class BadFormatException extends StudentsLifeException {

    /**
     * 
     * @param message
     */
    public BadFormatException(String message) {
		super(message);
	}

    /**
     * 
     * @param message
     * @param ex
     */
    public BadFormatException(String message, Throwable ex) {
		super(message, ex);
	}
}
