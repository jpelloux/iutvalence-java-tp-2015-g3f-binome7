package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

/* TODO Translate. */
/**
 * Point d'entrée du programme.
 *
 * @author TODO
 * @version TODO
 */
public class Main
{
	/* TODO Translate. */
	/**
	 * Point d'entrée du programme.
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
