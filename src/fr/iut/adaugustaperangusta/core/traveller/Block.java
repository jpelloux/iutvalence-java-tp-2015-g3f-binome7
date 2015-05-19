package fr.iut.adaugustaperangusta.core.traveller;

import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.Position;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/**
 * Pushable Block. The Character can <strong>push</strong> them.
 * The goal is to bring all of them on targets.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Block extends Traveller
{
	
	/**
	 * Block constructor.
	 * @param pos Block's position
	 * @param map Map containing the block
	 */
	public Block(Position pos, Map map, int blockNumber)
	{
		this.positionTrav = pos;
		this.mapTrav = map;
		this.travNumber=blockNumber;
		this.name =null;
	}
	
	/**
	 * Checks if the Block is pushable from a given Position.
	 * @param posPlayer Position from which the Block is pushed.
	 * @see Position
	 * @see RelativePos
	 */
	public boolean isPushableFrom(Position posPlayer)
	{
		RelativePos dirJoueur = null;
		try
		{
			dirJoueur = this.positionTrav.getRelative(posPlayer);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			switch(dirJoueur)
			{
			case EAST:
				return this.mapTrav.isAccessibleFrom(posPlayer, this.posToCheck(RelativePos.EAST));
			case NORTH:
				return this.mapTrav.isAccessibleFrom(posPlayer, this.posToCheck(RelativePos.NORTH));
			case SOUTH:
				return this.mapTrav.isAccessibleFrom(posPlayer, this.posToCheck(RelativePos.SOUTH));
			case WEST:
				return this.mapTrav.isAccessibleFrom(posPlayer, this.posToCheck(RelativePos.WEST));
			default:
				System.out.println("we reach isPushableFrom exceptions"); //TODO EXCEPTIONS...
				return false;
			}
		} catch (OutOfMapException e)
		{
			return false;
		}
		
	}



	/**
     * Display method.
     * Prints 'O' on standard output.
     * Is displayed at the center of each Cell.
     * Example : | O |
	 */
	@Override
	public String toString()
	{
		return "O";
	}

	/**
	 * This traveller is a Block.
	 * @return true if this Traveller is a Block
	 */
	@Override
	public boolean isBlock()
	{
		return true;
	}
}
