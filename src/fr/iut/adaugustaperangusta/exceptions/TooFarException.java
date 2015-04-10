package fr.iut.adaugustaperangusta.exceptions;

/**
 * If 2 Positions are not adjacent.
 * 
 * @author Axce
 * @version TODO
 */
public class TooFarException extends Exception
{
    /* TODO A good practice is to don't use this constructor. */
    public TooFarException() {
    }

    /* TODO This one is better. */
    public TooFarException(final String message) {
        super(message);
    }
}
