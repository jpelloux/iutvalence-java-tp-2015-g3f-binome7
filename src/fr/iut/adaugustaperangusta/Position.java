package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/* TODO Position is mutable ? */
/**
 * A Traveller's Position: x-axis and y-axis.
 *
 * @author jpelloux
 * @version 1.0.0
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
					return RelativePos.SOUTH;
				case 1:
					return RelativePos.NORTH;
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
					return RelativePos.EAST;
				case 1:
					return RelativePos.WEST;
				default:
					/* TODO A Java good practice is to never use Exception without text message. */
					throw new TooFarException();
			}
		}
        /* TODO A Java good practice is to never use Exception without text message. */
		throw new TooFarException();
	}

	public Position generatePosFromRelative(RelativePos direction)
	{
		int deltaX=0, deltaY=0;
		if(direction == RelativePos.EAST) deltaY ++;
		if(direction == RelativePos.WEST) deltaY --;
		if(direction == RelativePos.SOUTH) deltaX ++;
		if(direction == RelativePos.NORTH) deltaX --;
		
		return new Position(this.x+deltaX, this.y+deltaY);
	}
	
	public void addRelative(RelativePos direction)
	{
		// TODO gerer le dépacement de map 
		if(direction == RelativePos.EAST) this.y ++;
		if(direction == RelativePos.WEST) this.y --;
		if(direction == RelativePos.SOUTH) this.x ++;
		if(direction == RelativePos.NORTH) this.x --;
			
	}

	@Override
	public String toString()
	{
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
}
