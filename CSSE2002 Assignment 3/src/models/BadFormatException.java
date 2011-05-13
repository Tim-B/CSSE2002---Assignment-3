package models;

/**
 * This exception is thrown when there is a problem with the format
 * of an serialized card deck.
 */
public class BadFormatException extends StudentsLifeException {

	public BadFormatException(String message) {
		super(message);
	}

	public BadFormatException(String message, Throwable ex) {
		super(message, ex);
	}
}
