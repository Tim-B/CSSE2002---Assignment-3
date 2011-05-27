package models.impl;

//~--- non-JDK imports --------------------------------------------------------

import models.BadCardException;
import models.FreezePlayerCard;

/**
 * The implementation class for FreezePlayer cards.
 */
public class FreezePlayerCardImpl extends CardImpl implements FreezePlayerCard {

    /**
     *
     * @param name
     * @throws BadCardException
     */
    public FreezePlayerCardImpl(String name) throws BadCardException {

        super(name);

    }

    /**
     *
     * @param name
     * @param id
     * @throws BadCardException
     */
    public FreezePlayerCardImpl(String name, int id) throws BadCardException {

        super(name, id);

    }

    public int getScore() {

        return -2;

    }
}



