package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;
/**
 * Point d'entrée du programme.
 */
public class Main
{
	/**
	 * Point d'entrée du programme.
	 */
	public static void main(String[] args)
	{
		Character player = new Character("Findus", new Position(1, 1)); 
		Game game = new Game(new Map('a'), player);
		
		
	}
	
}
