package fr.iut.adaugustaperangusta.exceptions;

/**
 * If 2 Positions are the same.
 *
 * @author Axce
 * @version 1.0.0
 */
public class SamePosException extends Exception
{
//    /* TODO A good practice is to don't use this constructor. */
//    public SamePosException() {
//    }

    /* TODO This one is better. */
    public SamePosException(final String message) {
        super(message);
    }
}
