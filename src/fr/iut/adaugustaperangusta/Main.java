package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.utils.CreateMap;

/**
 * Entry point of the program.
 *
 * @author jpelloux & Axce
 * @version 1.1.0
 */
public class Main
{
	/**
	 * Entry point of the program.
	 */
	public static void main(String[] args)
	{
		Game game = new Game(CreateMap.importFromFile("Test.txt"),false);
		game.play();
	}

}
