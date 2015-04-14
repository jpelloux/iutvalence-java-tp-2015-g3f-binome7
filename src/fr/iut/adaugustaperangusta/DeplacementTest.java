package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

/**
 * A simple class to test deplacements fx.
 *
 * @author jpellou
 * @version 1.0.0
 */

public class DeplacementTest
{

	public static void main(String[] args)
	{
		 /**
	     * Main method.
	     *
	     * @param args useless
	     */
		
		Character player = new Character("Findus", new Position(1, 1));
		Game game = new Game(new Map('a'), player);
		
		
	}

}
