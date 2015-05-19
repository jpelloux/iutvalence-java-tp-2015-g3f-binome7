package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.coreModel.Map;
import fr.iut.adaugustaperangusta.coreModel.Position;

/**
 * Playable Character.
 * Can push Blocks.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Character extends Traveller
{

	/**
	 * Character constructor.
	 * 
	 * @param name	Character's name.
	 * @param pos   Character's Position.
	 * @param map   Character's Map.
	 */
	public Character(String name, Position pos,Map map)
	{
		this.name= name;
		this.positionTrav= pos;   
	}
	
	/**
	 * Character is not pushable.
	 * @return false
	 */
	public boolean isPushableFrom(Position posPlayer) {
		return false;
	}

	/**
	 * A character is not a Block.
	 * @return false
	 */
	public boolean isBlock()
	{
		return false;
	}

	/**
     * Display method.
     * Prints 'v' on standard output.
     * Is displayed at the center of the Cell.
     * Example : | v |
	 */
	@Override
	public String toString()
	{
		return "v";
	}
	
}
