package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Map;
import fr.iut.adaugustaperangusta.Position;
import fr.iut.adaugustaperangusta.RelativePos;
import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/* TODO Translate. */
/**
 * Bloc déplaçable. Le joueur peut les <strong>pousser</strong>. Le but est
 * d'amener tous les Blocks sur des Targets.
 *
 * @author jpelloux and Axce
 * @version 1.0.0
 */
public class Block extends Traveller
{
	
	/**
	 * Constructeur
	 * @param pos Position du block
	 * @param map Map contenant la map
	 */
	public Block(Position pos, Map map, int blockNumber)
	{
		this.positionTrav = pos;
		this.mapTrav = map;
		this.travNumber=blockNumber;
	}
	
	/**
	 * Verifie si le bloc est poussable depuis une position donné
	 *  @param posPlayer la position depuis laquelle le bloc est poussé
	 */
	public boolean isPushableFrom(Position posPlayer)
	{
		RelativePos dirJoueur = null;
		try
		{
			dirJoueur = this.positionTrav.getRelative(posPlayer);
		} catch (TooFarException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SamePosException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			System.out.println("we reach isPushableFrom exceptions"); //EXCEPTIONS...
			return false;
		}
		
	}


	/**
	 * Le block n'a pas de nom
	 * @see fr.iut.adaugustaperangusta.traveller.Traveller#getName()
	 */
	@Override
	public String getName()
	{
		return null;
	}

	/**
	 * Méthode d'affichage. Affiche le caractère 'O' sur la sortie standard. Ce
	 * caractère s'affiche au centre de chaque case.
	 */
	@Override
	public String toString()
	{
		return "O";
	}

	/* TODO JAVADOC. */
	public boolean isBlock()
	{
		return true;
	}
}
