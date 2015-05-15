package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/* TODO is Position mutable ? */
/**
 * A Traveller's Position: x-axis and y-axis.
 *
 * @author jpelloux
 * @version 1.1.0
 */
public class Position
{
	/**
	 * X-axis of the Position.
	 */
	private int x;

	/**
	 * Y-axis of the Position.
	 */
	private int y;

	/**
	 * Position's Constructor
	 * 
	 * @param x
	 *            X-axis of the Position
	 * @param y
	 *            Y-axis of the Position
	 */
	public Position(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * X-axis getter.
	 * 
	 * @return this.x
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * X-axis setter.
	 * 
	 * @param x
	 *            New X-axis.
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Y-axis getter.
	 * 
	 * @return this.y
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Y-axis setter.
	 * 
	 * @param y
	 *            New Y-axis.
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * Relative position OF an adjacent Position. Example : returns NORTH if the
	 * parameter is to the DIRECT NORTH of this.
	 *
	 * @param other
	 *            Position.
	 * @return RelativePos of an adjacent Position to this.
	 * @throws TooFarException
	 *             if the other Position is not adjacent to this.
	 */
	public RelativePos getRelative(Position other) throws TooFarException, SamePosException
	{
		int deltaX = other.x - this.x;
		int deltaY = other.y - this.y;

		if (deltaY == 0)
		{
			switch (deltaX)
			{
			case -1:
				return RelativePos.SOUTH;
			case 1:
				return RelativePos.NORTH;
			case 0:
				throw new SamePosException("this.position :" + this + " other position" + other);
			default:
				throw new TooFarException("this.position :" + this + " other position" + other);
			}
		}

		if (deltaX == 0)
		{
			switch (deltaY)
			{
			case -1:
				return RelativePos.EAST;
			case 1:
				return RelativePos.WEST;
			default:
				throw new TooFarException("this.position :" + this + " other position" + other);
			}
		}
		throw new TooFarException("this.position :" + this + " other position" + other);
	}

	/**
	 * Return a NEW Position equal to the Position of this after a movement in
	 * the given direction.
	 * 
	 * @param direction
	 *            The direction of the movement.
	 * @return a NEW Position.
	 */
	public Position generatePosFromRelative(RelativePos direction)
	{
		int deltaX = 0, deltaY = 0;
		if (direction == RelativePos.EAST)
			deltaY++;
		if (direction == RelativePos.WEST)
			deltaY--;
		if (direction == RelativePos.SOUTH)
			deltaX++;
		if (direction == RelativePos.NORTH)
			deltaX--;

		return new Position(this.x + deltaX, this.y + deltaY);
	}

	/**
	 * Return a NEW Position equal to the Position of this after a movement of
	 * "range" cell in the given direction.
	 * 
	 * @param direction
	 *            The direction of the movement.
	 * @param range
	 *            The number of block to travel in the given direction.
	 * @return a NEW Position.
	 */
	public Position generatePosFromRelativeAtRangeN(RelativePos direction, int range)
	{
		int deltaX = 0, deltaY = 0;
		if (direction == RelativePos.EAST)
			deltaY += range;
		if (direction == RelativePos.WEST)
			deltaY -= range;
		if (direction == RelativePos.SOUTH)
			deltaX += range;
		if (direction == RelativePos.NORTH)
			deltaX -= range;

		return new Position(this.x + deltaX, this.y + deltaY);
	}

	/**
	 * Update the position after a movement in the given position.
	 * 
	 * @param direction
	 *            The direction of the movement.
	 */
	public void addRelative(RelativePos direction)
	{
		if (direction == RelativePos.EAST)
			this.y++;
		if (direction == RelativePos.WEST)
			this.y--;
		if (direction == RelativePos.SOUTH)
			this.x++;
		if (direction == RelativePos.NORTH)
			this.x--;
	}

	/**
	 * toString redefinition. Display the X and Y of this.
	 */
	@Override
	public String toString()
	{
		return "Position [x=" + x + ", y=" + y + "]";
	}

}
