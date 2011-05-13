package models.impl;

import models.BadCardException;
import models.BonusCard;

/**
 * The implementation class for Bonus cards.
 */
public class BonusCardImpl extends CardImpl implements BonusCard {
	
	private BonusCardType type;

	public BonusCardImpl(String name, int id, BonusCard.BonusCardType type) 
	throws BadCardException {
		super(name, id);
		this.type = type;
	}
	
	public BonusCardImpl(String name, BonusCard.BonusCardType type) 
	throws BadCardException {
		super(name);
		this.type = type;
    }
	
	public BonusCardType getType() {
		return this.type;
	}

	public int getScore() {
		return 0;
	}
	
}
