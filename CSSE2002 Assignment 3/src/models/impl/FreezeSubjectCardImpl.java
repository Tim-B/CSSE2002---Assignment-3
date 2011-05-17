package models.impl;

import models.BadCardException;
import models.FreezeSubjectCard;

/**
 * The implementation class for FreezeSubject cards.
 */
public class FreezeSubjectCardImpl extends CardImpl implements FreezeSubjectCard {
	
	/** Type of this FreezeSubjectCard */
	private FreezeSubjectCardType type;

        /**
         * 
         * @param name
         * @param id
         * @param type
         * @throws BadCardException
         */
        public FreezeSubjectCardImpl(String name, int id, 
			FreezeSubjectCardType type) throws BadCardException {
		super(name, id);
		this.type = type;
	}

        /**
         * 
         * @param name
         * @param type
         * @throws BadCardException
         */
        public FreezeSubjectCardImpl(String name, FreezeSubjectCardType type) 
	        throws BadCardException {
		super(name);
		this.type = type;
	}

	public int getScore() {
		return -1;
	}

	public FreezeSubjectCardType getType() {
		return this.type;
	}


}
