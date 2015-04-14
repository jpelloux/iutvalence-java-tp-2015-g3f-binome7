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
		RelativePos dirDeptTest;
		dirDeptTest = RelativePos.SOUTH;
		
		Character player = new Character("Findus", new Position(2, 1));
		Game game = new Game(new Map('a'), player);
		
		System.out.println(game.getMap());
		System.out.println(game.getCharacter().getPositionTrav());
		System.out.println(game.getMap().getCell(game.getCharacter().getPositionTrav()).getTraveller());
		System.out.println(game.getMap().getCell(game.getCharacter().posToCheck(dirDeptTest)).getTraveller());
		
		
		if(game.getMap().isAccessible(game.getMap().getCell(game.getCharacter().posToCheck(dirDeptTest))))
		{
			game.getMap().moveTrav(game.getCharacter().getPositionTrav(), game.getCharacter().posToCheck(dirDeptTest));
			game.getCharacter().move(dirDeptTest);
		}
		else
		{
			System.out.println("Dpt imp"); //Test moche
		}
		
		System.out.println(game.getMap());
		System.out.println(game.getCharacter().getPositionTrav());
		System.out.println(game.getMap().getCell(game.getCharacter().getPositionTrav()).getTraveller());
		System.out.println(game.getMap().getCell(game.getCharacter().posToCheck(dirDeptTest)).getTraveller());
	}
}
