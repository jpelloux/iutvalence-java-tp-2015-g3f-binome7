package fr.iut.adaugustaperangusta.exceptions;

/**
 * If two Positions are the same.
 *
 * @author Axce
 * @version 1.1.0
 */
public class SamePosException extends Exception {
	public SamePosException(final String message) {
		super(message);
	}
}
