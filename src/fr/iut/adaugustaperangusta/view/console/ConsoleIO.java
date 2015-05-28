package fr.iut.adaugustaperangusta.view.console;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.utils.CreateMap;
import fr.iut.adaugustaperangusta.view.View;

public class ConsoleIO implements View {
	private final Game game;

	public ConsoleIO(Game game) {
		this.game = game;
	}

	public final void displayMap(Map map) {
		System.out.println(map);
	}

	public final void displayWin() {
		System.out.println("Good Job!");
	}

	public final void displayInvalideMove(RelativePos dirDeptTest,
			Traveller character) {
		System.out.println("-------------");
		System.out.println("Dpt imp"); // Test moche
		System.out.println(dirDeptTest);
		System.out.println(character.getPositionTrav());
		System.out.println(character.posToCheck(dirDeptTest));
	}

	public final void displayInvalideInput() {
		System.out.println("Invalid Input");
	}

	/**
	 * Converts a <tt>char</tt> (z,q,s,d) into a RelativePos.
	 * 
	 * @return the player's next move.
	 * @see RelativePos
	 */
	public final RelativePos getMove() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String mouvement = sc.nextLine();
			char charMvt;
			if (mouvement.length() > 1)
				continue; // More than 1 char in stdin
			try {
				charMvt = mouvement.charAt(0);

			} catch (Exception e) // 0 char in stdin
			{
				continue;
			}

			switch (charMvt) {
			case 'z':
				return RelativePos.NORTH;
			case 'q':
				return RelativePos.WEST;
			case 's':
				return RelativePos.SOUTH;
			case 'd':
				return RelativePos.EAST;
			default:
				this.displayInvalideInput();
			}
		}
	}

	@Override
	public void play() {

		RelativePos dirDeptTest = null;
		this.displayMap(game.getMap());

		while (!(game.isWon())) {
			dirDeptTest = this.getMove();

			if (game.isCharacterMovable(dirDeptTest)) {
				try {
					game.getMap().moveTrav(
							game.getCharacter().getPositionTrav(),
							game.getCharacter().posToCheck(dirDeptTest));// tableau
					game.getCharacter().move(dirDeptTest);// positions
				} catch (OutOfMapException e) {
					this.displayInvalideMove(dirDeptTest, game.getCharacter());
				}

			} else {
				this.displayInvalideMove(dirDeptTest, game.getCharacter());
			}
			this.displayMap(game.getMap());
		}
		this.displayWin();
	}

	private void replay() {
		Game game = new Game(CreateMap.importFromFile("Test.txt"), true);
	}
}
