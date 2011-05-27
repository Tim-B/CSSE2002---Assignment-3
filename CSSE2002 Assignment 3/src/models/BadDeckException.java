package models;

/**
 * This exception is thrown when a problem occurs while assembling
 * a Deck of cards.
 */
public class BadDeckException extends StudentsLifeException {

    /**
     *
     * @param message
     */
    public BadDeckException(String message) {

        super(message);

    }

    /**
     *
     * @param message
     * @param ex
     */
    public BadDeckException(String message, Throwable ex) {

        super(message, ex);

    }
}



