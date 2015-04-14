package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Position;
import fr.iut.adaugustaperangusta.RelativePos;

/* TODO Translate. */

/**
 * Objets en mouvement.
 * Classe abstraite. Super-classe de tous les objets en mouvement sur la map.
 * Block et Character en sont héritées.
 *
 * @author TODO
 * @version TODO
 */
public abstract class Traveller {
	
	protected Position positionTrav;
    //TODO Traveller : voir où on enregistre la position
    //	private Position	position;
    //	public Position getPosition()
    //	{
    //		return this.position;
    //	}
	
	/* TODO Translate. */
	/** Position du Traveller. */
    public abstract String getName();
    
    
    void move(RelativePos direction)
    {
    	try
		{
			this.getPositionTrav().getRelative(//posDir);
		}
		catch (Exception e)
		{

		}
    }


	public Position getPositionTrav()
	{
		return positionTrav;
	}


	public void setPositionTrav(Position positionTrav)
	{
		this.positionTrav = positionTrav;
	}
    
}
