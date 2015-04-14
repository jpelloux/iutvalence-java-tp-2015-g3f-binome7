package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Position;

/* TODO Translate. */
/**
 * Bloc déplaçable. Le joueur peut les <strong>pousser</strong>. Le but est
 * d'amener tous les Blocks sur des Targets.
 *
 * @author TODO
 * @version TODO
 */
public class Block extends Traveller {
    
	public Block(Position pos)
	{
		this.positionTrav= pos;
	}
	
	
	public boolean isPushableFrom(Position posPlayer) {
        //		int newX, newY;
        //		newX =
        //Position newPos;
        //newPos= new Position()
        return true;
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
