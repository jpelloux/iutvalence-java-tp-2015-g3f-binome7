package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/**
 * Position d'un Traveller.
 * Contient une abcisse (x), une ordonnée (y), des getters et des setters.
 */
public class Position
{
	private int	x;
	private int	y;
	
	public Position(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
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
					throw new SamePosException();
				default:
					throw new TooFarException();
			}
		}
		
		else if (deltaX == 0)
			
		{
			switch(deltaY)
			{
				case -1:
					return RelativePos.NORTH;
				case 1:
					return RelativePos.SOUTH;
				default:
					throw new TooFarException();
			}
		}
		
		throw new TooFarException();
	}
	
}
