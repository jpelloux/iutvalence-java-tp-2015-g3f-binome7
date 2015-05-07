package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

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

		//Character player = new Character("Findus", new Position(8, 5)); // Faire les verif de creation de perso concordant avec la map
		//Game game = new Game(CreateMap.importFromFile("Test.txt"), player);
		Game game = new Game(CreateMap.importFromFile("Test.txt"));
		game.play();
	}

}
