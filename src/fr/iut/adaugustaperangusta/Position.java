package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/* TODO Position is mutable ? */
/* TODO Translate. */
/**
 * Position d'un Traveller : abcisse (x) et ordonnée (y).
 *
 * @author TODO
 * @version TODO
 */
public class Position
{
	/* TODO JAVADOC. */
	private int x;
	/* TODO JAVADOC. */
	private int y;

	/* TODO JAVADOC. */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/* TODO JAVADOC. */
	public int getX() {
		return x;
	}

	/* TODO JAVADOC. */
	public void setX(int x) {
		this.x = x;
	}

	/* TODO JAVADOC. */
	public int getY() {
		return y;
	}

	/* TODO JAVADOC. */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Relative position OF an adjacent Position.
	 * Example : returns NORTH if the parameter is to the DIRECT NORTH of this.
	 *
	 * @param other Position.
	 * @return RelativePos of an adjacent Position to this.
	 * @throws TooFarException if the other Position is not adjacent to this.
	 */
	public RelativePos getRelative(Position other) throws TooFarException, SamePosException
	{
		int deltaX = other.x - this.x;
		int deltaY = other.y - this.y;

		if (deltaY == 0)
		{
			switch(deltaX)
			{
				case -1:
					return RelativePos.WEST;
				case 1:
					return RelativePos.EAST;
				case 0:
					/* TODO A Java good practice is to never use Exception without text message. */
					throw new SamePosException();
				default:
					/* TODO A Java good practice is to never use Exception without text message. */
					throw new TooFarException();
			}
		}

		if (deltaX == 0)
		{
			switch(deltaY)
			{
				case -1:
					return RelativePos.NORTH;
				case 1:
					return RelativePos.SOUTH;
				default:
					/* TODO A Java good practice is to never use Exception without text message. */
					throw new TooFarException();
			}
		}
        /* TODO A Java good practice is to never use Exception without text message. */
		throw new TooFarException();
	}

}
