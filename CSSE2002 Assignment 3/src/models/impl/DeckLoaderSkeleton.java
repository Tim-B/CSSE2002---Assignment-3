package models.impl;

//~--- non-JDK imports --------------------------------------------------------

import models.BadFormatException;
import models.Deck;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * The DeckLoader class is responsible for reading and writing
 * decks of cards.  This class follows the Singleton Class
 * design pattern, with {@link #getInstance()} returning the
 * singleton instance.
 *
 * <h3>File Format</h3>
 * <p>
 * The file format for a deck of cards consists of zero or more
 * <u>card description</u> lines terminated with line separators
 * (as described below).  A <u>card description</u> line consists
 * of 3 or 4 fields separated by a comma (",") character, where the
 * fields are as follows
 * <ul>
 *   <li>Field 1 is the card type, and is one of the values listed in
 *       the next section.</li>
 *   <li>Field 2 is a card count.  It is a non-negative integer.</li>
 *   <li>Field 3 is the card name.  It is a non-empty String.</li>
 *   <li>Field 4 is the card id.  If present, it is an integer.</li>
 * </ul>
 * If the card id field is present, the card count should be 1, and
 * the card description specifies that a single card should be created with
 * the given id.  If the card field is absent, the card count specifies
 * the number of cards to be created.
 *
 * <h3>Card types</h3>
 * The following card type strings should be supported:
 * <ul>
 * <li>"subject" - denotes a SubjectCard instance.</li>
 * <li>"freeze_player" - denotes a FreezePlayerCard instance.</li>
 * <li>"freeze_subject" - denotes a FreezeSubjectCard instance with type NORMAL.</li>
 * <li>"grade" - denotes a FreezeSubjectCard instance with type GRADE.</li>
 * <li>"unfreeze_player" - denotes a BonusCard with type UNFREEZE_PLAYER.</li>
 * <li>"unfreeze_subject" - denotes a BonusCard with type UNFREEZE_SUBJECT.</li>
 * <li>"steal_one_player" - denotes a BonusCard with type STEAL_ONE_PLAYER.</li>
 * <li>"steal_all_players" - denotes a BonusCard with type STEAL_ALL_PLAYERS.</li>
 * </ul>
 * <p>
 *
 * <h3>Line Separators</h3>
 * <p>
 * When the file is written, the current platform's line separator
 * shall be used.  When the file is read, any of the following shall
 * be accepted as a line separator:
 * <ul>
 * <li>CR (i.e. "\r") - Mac style.</li>
 * <li>NL (i.e. "\n") - UNIX / Linux style.</li>
 * <li>CR NL (i.e. "\r\n") - DOS / Windows style. </li>
 * </ul>
 *
 * <h3>Examples</h3>
 * Here is a file consisting of 3-field card descriptors; e.g.
 * for initializing a fresh deck of cards.
 * <pre>
 * subject,30,Subject Card
 * grade,20,Grade Card
 * freeze_player,10,Computer Virus
 * freeze_subject,10,Food Poisoning
 * unfreeze_player,6,Anti-Virus
 * unfreeze_subject,6,Medical Certificate
 * steal_one_player,3,Computer Hack
 * steal_all_players,2,Mind Control
 * </pre>
 * Here is a file of 4-field card descriptors; e.g.
 * representing a saved deck of cards.
 * <pre>
 * subject,1,Subject Card,21
 * grade,1,Grade Card,1
 * grade,1,Grade Card,15
 * freeze_player,1,Computer Virus,26
 * subject,1,Subject Card,8
 * subject,1,Subject Card,13
 * </pre>
 */
public class DeckLoaderSkeleton {

    // Add declarations if / as required.

    /**
     * Return the instance of this class.
     *
     * @return the singleton DeckLoader instance.
     */
    public static DeckLoaderSkeleton getInstance() {

        return null;    // change to return the singleton instance

    }

    /**
     * Load a deck of cards from a file.  The format of the file is as
     * specified in the class-level javadoc.  Both 3 and 4 field card
     * descriptions are supported.
     *
     * @param file the file containing the serialized deck of cards.
     * @return the deck of cards.
     * @throws IOException if there is a problem opening or reading the file.
     * @throws BadFormatException if there is a problem with the format
     *         of the input file / stream, or if the resulting cards or
     *         deck violate their respective invariants.
     */
    public Deck load(File file) throws IOException, BadFormatException {

        // Implement
        //
        // You may rely on the Deck and Card implementations' class
        // constructors to perform any required validation of their
        // parameters; e.g. checking card names, checking for duplicate
        // cards in the initial deck
        return null;    // replace
    }

    /**
     * Load a deck of cards from a Reader.  The format of the character
     * stream is as specified in the class-level javadoc.  Both 3 and 4
     * field card descriptions are supported.
     *
     * @param reader the reader containing the serialized deck of cards.
     * @return the deck of cards.
     * @throws IOException if there is a problem reading the reader.
     * @throws BadFormatException if there is a problem with the format
     *         of the input file / stream, or if the resulting cards or
     *         deck violate their respective invariants.
     */
    public Deck load(Reader reader) throws IOException, BadFormatException {

        // Implement
        //
        // You may rely on the Deck and Card implementations' class
        // constructors to perform any required validation of their
        // parameters; e.g. checking card names, checking for duplicate
        // cards in the initial deck
        return null;    // replace
    }

    /**
     * Save a deck of cards to a file using 4 field card descriptions
     * as specified in the class-level javadoc.
     *
     * @param deck the Deck to be saved.
     * @param file the File to save the files to.
     * @throws IOException if there is a problem opening or writing the file.
     */
    public void save(Deck deck, File file) throws IOException {

        // Implement
    }
}



