package fr.iut.adaugustaperangusta.exceptions;

/**
 * If 2 Positions are not adjacent.
 * 
 * @author Axce
 * @version 1.0.0
 */
public class TooFarException extends Exception
{
    public TooFarException(final String message) {
        super(message);
    }
}
