package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Position;

/**
 * Bloc déplaçable. Le joueur peut les <strong>pousser</strong>. Le but est
 * d'amener tous les Blocks sur des Targets.
 */
public class Block extends Traveller
{
	/**
	 * Méthode d'affichage. Affiche le caractère 'O' sur la sortie standard. Ce
	 * caractère s'affiche au centre de chaque case.
	 */
	
	public boolean isPushableFrom(Position posPlayer)
	{
//		int newX, newY;
//		newX =
		
		//Position newPos;
		//newPos= new Position()
		return true;
	}
	
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString()
	{
		return "O";
	}
}
