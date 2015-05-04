package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Map;
import fr.iut.adaugustaperangusta.Position;
import fr.iut.adaugustaperangusta.RelativePos;

/* TODO Translate. */

/**
 * Objets en mouvement. Classe abstraite. Super-classe de tous les objets en
 * mouvement sur la map. Block et Character en sont héritées.
 *
 * @author TODO
 * @version TODO
 */
public abstract class Traveller
{

	protected Position positionTrav;
	protected Map mapTrav;
	protected int travNumber;
	// TODO Traveller : voir où on enregistre la position
	// private Position position;
	// public Position getPosition()
	// {
	// return this.position;
	// }

	/* TODO Translate. */
	/** Position du Traveller. */
	public abstract String getName();

	public abstract boolean isPushableFrom(Position posPlayer);
	
	public abstract boolean isBlock();
	
	public Position posToCheck(RelativePos direction)
	{
		return (this.positionTrav.generatePosFromRelative(direction));
	}

	public void move(RelativePos direction)
	{

		this.positionTrav.addRelative(direction); 
	}

	public Position getPositionTrav()
	{
		return positionTrav;
	}

	public void setPositionTrav(Position positionTrav)
	{
		this.positionTrav = positionTrav;
	}

	public Map getMapTrav()
	{
		return mapTrav;
	}

	public void setMapTrav(Map mapTrav)
	{
		this.mapTrav = mapTrav;
	}

	public int getTravNumber()
	{
		return this.travNumber;
	}

	
	
}
