package models;

/**
 * This exception is thrown when a problem occurs while creating
 * a Card.
 */
public class BadCardException extends StudentsLifeException {

	public BadCardException(String message) {
		super(message);
	}

	public BadCardException(String message, Throwable ex) {
		super(message, ex);
	}
}
