package models;

/**
 * This exception is thrown when an illegal operation is performed
 * on a deck of cards.
 */
public class BadDeckOperationException extends StudentsLifeException {

    /**
     *
     * @param message
     */
    public BadDeckOperationException(String message) {

        super(message);

    }

    /**
     *
     * @param message
     * @param ex
     */
    public BadDeckOperationException(String message, Throwable ex) {

        super(message, ex);

    }
}



