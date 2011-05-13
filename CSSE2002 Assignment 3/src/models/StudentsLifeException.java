package models;

/**
 * Base exception class for the Students Life game.
 */
public abstract class StudentsLifeException extends Exception {

	public StudentsLifeException(String message) {
		super(message);
	}
	
	public StudentsLifeException(String message, Throwable ex) {
		super(message, ex);
	}
}
