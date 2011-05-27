package models;

/**
 * Base exception class for the Students Life game.
 */
public abstract class StudentsLifeException extends Exception {

    /**
     *
     * @param message
     */
    public StudentsLifeException(String message) {

        super(message);

    }

    /**
     *
     * @param message
     * @param ex
     */
    public StudentsLifeException(String message, Throwable ex) {

        super(message, ex);

    }
}



