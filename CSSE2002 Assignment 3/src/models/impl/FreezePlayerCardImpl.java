package models.impl;

import models.BadCardException;
import models.FreezePlayerCard;

/**
 * The implementation class for FreezePlayer cards.
 */
public class FreezePlayerCardImpl extends CardImpl implements FreezePlayerCard {

	public FreezePlayerCardImpl(String name, int id) throws BadCardException {
		super(name, id);
	}

	public FreezePlayerCardImpl(String name) throws BadCardException {
		super(name);
	}

	public int getScore() {
		return -2;
	}

}
