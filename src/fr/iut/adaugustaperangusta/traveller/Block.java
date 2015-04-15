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
 * @author TODO
 * @version TODO
 */
public class Block extends Traveller {
    
	public Block(Position pos, Map map)
	{
		this.positionTrav= pos;
		this.mapTrav = map;
	}
	
	
	public boolean isPushableFrom(Position posPlayer) {
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
		
		System.out.println("1");
		System.out.println(dirJoueur);
		if(dirJoueur==RelativePos.SOUTH) return this.mapTrav.isAccessibleFrom(posPlayer,this.posToCheck(RelativePos.NORTH));
		if(dirJoueur==RelativePos.NORTH) return this.mapTrav.isAccessibleFrom(posPlayer,this.posToCheck(RelativePos.SOUTH));
		if(dirJoueur==RelativePos.EAST) return this.mapTrav.isAccessibleFrom(posPlayer,this.posToCheck(RelativePos.WEST));
		if(dirJoueur==RelativePos.WEST) return this.mapTrav.isAccessibleFrom(posPlayer,this.posToCheck(RelativePos.EAST));
       
			
		return false; // Exceptions ...
    }

    @Override
    public String getName() {
        return null;
    }

    /**
     * Méthode d'affichage. Affiche le caractère 'O' sur la sortie standard. Ce
     * caractère s'affiche au centre de chaque case.
     */
    @Override
    public String toString() {
        return "O";
    }
}
