package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.utils.CreateMap;

/**
 * Entry point of the program.
 *
 * @author jpelloux & Axce
 * @version 1.1.0
 */
public class Main {
	private static final String DEFAULT_MAP = "Test.txt";
	private static final boolean USE_GUI = true;
	private static final boolean NO_USE_GUI = false;

	/**
	 * Entry point of the program.
	 */
	public static void main(String[] args) {
		Game game = new Game(CreateMap.importFromFile(DEFAULT_MAP), USE_GUI);
		game.play();
	}

}
