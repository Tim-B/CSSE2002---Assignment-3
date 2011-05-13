package models.impl;

import models.BadCardException;
import models.BadDeckException;
import models.BonusCard.BonusCardType;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

import models.BadFormatException;
import models.BonusCard;
import models.Card;
import models.Deck;
import models.FreezeSubjectCard;
import models.FreezeSubjectCard.FreezeSubjectCardType;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

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

 * </pre>
 */
public class DeckLoader {

	/**
	 * Stored the singleton class instance
	 */
	private static DeckLoader classInstance = new DeckLoader();

	/**
	 * Stores the current card count, used to generate ID
	 */
	private int cardcnt;

	/**
	 * Private constructor to prevent direct instanation.
	 */
	private DeckLoader(){
		
	}

	/*
	 * Invariants.
	 * 'classInstance' contains the instance of the singleton class.
	 */
	
	/**
	 * Return the instance of this class.
	 * 
	 * @return the singleton DeckLoader instance.
	 */
	public static DeckLoader getInstance() {
	
		return classInstance;
		
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
	public Deck load(File file) throws IOException, BadFormatException{

		try{

			//Convert file to a reader
			FileReader reader = new FileReader(file);

			//Pass to reader load function
			Deck deck = load(reader);

			reader.close();

			return deck;

		} catch(FileNotFoundException exep) {

			throw new IOException(exep);

		} catch (Exception exep) {

			throw new BadFormatException("Cards are badly formatted", exep);

		}

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
	public Deck load(Reader reader) throws IOException, BadFormatException{

		try{

			LineNumberReader lineRead = new LineNumberReader(reader);

			ArrayList<String[]> lines = new ArrayList();

			String line;

			cardcnt = 0;

			ArrayList<Card> deck = new ArrayList();

			//Generate ArrayList of arrays to represent each line
			//Each line split by , delimiter to form array
			while((line = lineRead.readLine()) != null){

				lines.add(line.split(","));

			}

			//Pass lines to helper function which returns deck
			deck = generateCards(lines);

			Card[] deckarray = new Card[deck.size()];

			//Convert ArrayList to Array to pass to DeckImpl constructor
			for(int i = 0; i < deck.size(); i++){

				deckarray[i] = deck.get(i);

			}

			lineRead.close();

			return new DeckImpl(deckarray);

		} catch(FileNotFoundException exep) {

			throw new IOException(exep);

		} catch (Exception exep) {

			throw new BadFormatException("Cards are badly formatted", exep);

		}
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

		try{

			Deck deckcopy = deck;

			FileWriter writer = new FileWriter(file);

			BufferedWriter lineWriter = new BufferedWriter(writer);

			String line;
			
			//Piece together line

			for(Card card : deckcopy){

				line = translateToName(card);

				line = line.concat(",");

				line = line.concat("1");

				line = line.concat(",");

				line = line.concat(card.getName());

				line = line.concat(",");

				String id = Integer.toString(card.getId());

				line = line.concat(id);

				lineWriter.write(line);

				lineWriter.newLine();

			}

			lineWriter.close();

			writer.close();
		
		}catch(FileNotFoundException exep) {

			throw new IOException(exep);

		}

	}

	/**
	 * Helper function to return a list of cards based on an ArrayList
	 * of arrays containing the data about a card.
	 * @param lines An ArrayList of String arrays
	 * @return ArrayList<Card> returns an ArrayList of cards based on input
	 * @throws BadFormatException if the card type cannot be found
	 * @throws BadCardException if a card input is not valid
	 */
	private ArrayList<Card> generateCards(ArrayList<String[]> lines) throws BadFormatException, BadCardException{

		ArrayList<Card> cards = new ArrayList();

		ArrayList<Integer> definedids = new ArrayList();

		//Generates a list of fixed IDs defined in the file
		for(String[] line : lines){
		
			if(line.length == 4){
			
				definedids.add(Integer.parseInt(line[3]));
				
			}
			
		}

		for(String[] line : lines){
			
			int cardcount = Integer.parseInt(line[1]);

			int id;

			for(int i = 0; i < cardcount; i++){

				if(line.length == 3){

					//Increment card ID
					cardcnt++;

					//If card ID is already taken by a card with a fixed ID
					//continue incrementing until a unique ID is found
					while(definedids.contains(cardcnt)){

						cardcnt++;

					}

					id = cardcnt;

				}else{

					id = Integer.parseInt(line[3]);

				}

				cards.add(translateCard(line[0], id, line[2]));

			}
			
		}

		return cards;

	}

	/**
	 * Translates the string of the card type into a class then instanate
	 * that class.
	 * @param type The type of the card as a string.
	 * @param id The ID of the card to be generated
	 * @param name The name of the card to be generate
	 * @return card The card instance
	 * @throws BadFormatException if the card type cannot be found
	 * @throws BadCardException if the card cannot be created
	 */
	private Card translateCard(String type, int id, String name) throws BadFormatException, BadCardException{

		if(type.equals("subject")){

		   return new SubjectCardImpl(name, id);

		}else if(type.equals("freeze_player")){

			return new FreezePlayerCardImpl(name, id);

		}else if(type.equals("freeze_subject")){

			FreezeSubjectCardType cardVariant = FreezeSubjectCardType.NORMAL;

			return new FreezeSubjectCardImpl(name, id, cardVariant);

		}else if(type.equals("grade")){

			FreezeSubjectCardType cardVariant = FreezeSubjectCardType.GRADE;

			return new FreezeSubjectCardImpl(name, id, cardVariant);

		}else if(type.equals("unfreeze_player")){

			BonusCard.BonusCardType cardVariant = BonusCard.BonusCardType.UNFREEZE_PLAYER;

			return new BonusCardImpl(name, id, cardVariant);

		}else if(type.equals("unfreeze_subject")){

			BonusCard.BonusCardType cardVariant = BonusCard.BonusCardType.UNFREEZE_SUBJECT;

			return new BonusCardImpl(name, id, cardVariant);

		}else if(type.equals("steal_one_player")){

			BonusCard.BonusCardType cardVariant = BonusCard.BonusCardType.STEAL_ONE_PLAYER;

			return new BonusCardImpl(name, id, cardVariant);

		}else if(type.equals("steal_all_players")){

			BonusCard.BonusCardType cardVariant = BonusCard.BonusCardType.STEAL_ALL_PLAYERS;

			return new BonusCardImpl(name, id, cardVariant);

		}else{

			throw new BadFormatException("Card not recognised: "+type);
			
		}
		
	}

	/**
	 * Translates a card into it's string card type
	 * @param card the card to be translated
	 * @return the string representing the type of card
	 */
	private String translateToName(Card card){

		String cardClass = card.getClass().getSimpleName().toString();

		 if(cardClass.equals("BonusCardImpl")){

			BonusCardImpl bonusCard = (BonusCardImpl) card;

			BonusCardType type = bonusCard.getType();

			if(type.equals(BonusCard.BonusCardType.UNFREEZE_PLAYER)){

				return "unfreeze_player";

			}else if(type.equals(BonusCard.BonusCardType.UNFREEZE_SUBJECT)){

				return "unfreeze_subject";

			}else if(type.equals(BonusCard.BonusCardType.STEAL_ONE_PLAYER)){

				return "steal_one_player";

			}else if(type.equals(BonusCard.BonusCardType.STEAL_ALL_PLAYERS)){

				return "steal_all_players";

			}

		}else if(cardClass.equals("FreezeSubjectCardImpl")){

			FreezeSubjectCardImpl freezePlayerCard = (FreezeSubjectCardImpl) card;

			FreezeSubjectCardType type = freezePlayerCard.getType();

			if(type.equals(FreezeSubjectCard.FreezeSubjectCardType.GRADE)){

				return "grade";

			}else if(type.equals(FreezeSubjectCard.FreezeSubjectCardType.NORMAL)){

				return "freeze_subject";

			}

		}else if(cardClass.equals("FreezePlayerCardImpl")){

			return "freeze_player";
			
		}

		return "subject";
			 
	}
	
}
