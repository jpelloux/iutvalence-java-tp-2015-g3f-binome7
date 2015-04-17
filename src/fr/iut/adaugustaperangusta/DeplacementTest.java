package fr.iut.adaugustaperangusta;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;
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
		 * @param args
		 *            useless
		 */
		RelativePos dirDeptTest;
		dirDeptTest = null;

		//Character player = new Character("Findus", new Position(8, 4));
		Character player = new Character("Findus", new Position(4, 3));
		 Game game = new Game(new Map('a'), player);
		//Game game = new Game(CreateMap.importFromFile("Test.txt"), player);

		System.out.println(game.getMap());
		System.out.println(game.getCharacter().getPositionTrav());
		System.out.println(game.getMap().getCell(game.getCharacter().getPositionTrav()).getTraveller());
		System.out.println(game.getMap().getCell(game.getCharacter().posToCheck(dirDeptTest)).getTraveller());

		Scanner sc = new Scanner(System.in);
		while (true)
		{
			//CHOIX DIRECTION
			String mouvement = sc.nextLine();
			char charMvt = mouvement.charAt(0);

			switch (charMvt)
			{
			case 'z':
				dirDeptTest = RelativePos.NORTH;
				break;
			case 'q':
				dirDeptTest = RelativePos.WEST;
				break;
			case 's':
				dirDeptTest = RelativePos.SOUTH;
				break;
			case 'd':
				dirDeptTest = RelativePos.EAST;
				break;
			default:
				System.out.println("Default case reach"); // Test moche
				System.out.println("Exit programme");
				dirDeptTest =null;
				break;
			}
			
			// EXIT
			if(dirDeptTest ==null) break;
			
			// DEPLACEMENT
			if (game.getMap().isAccessibleFrom(game.getCharacter().getPositionTrav(), game.getCharacter().posToCheck(dirDeptTest)))
			{
				System.out.println("dpt en cours");
				
				//DEPL PERSO
				game.getMap().moveTrav(game.getCharacter().getPositionTrav(), game.getCharacter().posToCheck(dirDeptTest));
				game.getCharacter().move(dirDeptTest);
			} else
			{
				System.out.println("-------------");
				System.out.println("Dpt imp"); // Test moche
				System.out.println(dirDeptTest);
				System.out.println(game.getCharacter().getPositionTrav());
				System.out.println(game.getCharacter().posToCheck(dirDeptTest));
			}
			
			System.out.println(game.getMap());
			System.out.println(game.getCharacter().getPositionTrav());
			//System.out.println(game.getMap().getCell(game.getCharacter().getPositionTrav()).getTraveller());
			//System.out.println(game.getMap().getCell(game.getCharacter().posToCheck(dirDeptTest)).getTraveller());

		}
	}
}
