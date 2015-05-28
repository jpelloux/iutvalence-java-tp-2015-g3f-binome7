package fr.iut.adaugustaperangusta.exceptions;

/**
 * If two Positions are not adjacent.
 * 
 * @author Axce
 * @version 1.1.0
 */
public class TooFarException extends Exception {
	public TooFarException(final String message) {
		super(message);
	}
}
