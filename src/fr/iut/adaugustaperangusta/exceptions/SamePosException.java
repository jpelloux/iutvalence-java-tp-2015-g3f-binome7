package fr.iut.adaugustaperangusta.exceptions;

/**
 * If 2 Positions are the same.
 *
 * @author Axce
 * @version 1.0.0
 */
public class SamePosException extends Exception
{
    public SamePosException(final String message) {
        super(message);
    }
}
