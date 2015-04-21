package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

/* TODO Translate. */
/**
 * Entry point of the program.
 *
 * @author jpelloux & Axce
 * @version 1.0.0
 */
public class Main
{
	/* TODO Translate. */
	/**
	 * Entry point of the program.
	 */
	public static void main(String[] args)
	{
		Character player = new Character("Findus", new Position(1, 1));
		Game game = new Game(new Map('a'), player);

		//Test Position getRelative
		try
		{
			System.out.println(new Position(1, 1).getRelative(new Position(2, 1)));
		}
		catch (Exception e)
		{

		}
	}

}
