package fr.iut.adaugustaperangusta.controller;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.Position;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.overlay.Target;
import fr.iut.adaugustaperangusta.core.traveller.Block;
import fr.iut.adaugustaperangusta.core.traveller.Character;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.view.View;
import fr.iut.adaugustaperangusta.view.console.ConsoleIO;
import fr.iut.adaugustaperangusta.view.gui.GuiIO;

/**
 * Class containing the attributes of one game.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Game {

	/**
	 * Map used for the Game.
	 */
	private Map map;

	/**
	 * Character used for the Game.
	 */
	private Character character;

	private View view;

	/**
	 * Game constructor. Sets the map to be solved.
	 */
	public Game(Map map, boolean gameType) {
		this.map = map;
		this.character = null;
		this.implementPlayer();
		if (gameType == false)
			this.view = new ConsoleIO(this);
		else
			this.view = new GuiIO(this);
	}

	/**
	 * Search for the Character into the Map to put it into the
	 * <tt>character</tt> field.
	 */
	private void implementPlayer() {
		for (int mapHeight = 0; mapHeight < this.map.getHeight(); mapHeight++) {
			for (int mapWidth = 0; mapWidth < this.map.getWidth(); mapWidth++) {
				try {
					if (this.map.getCell(new Position(mapHeight, mapWidth))
							.getTraveller() != null
							&& this.map
									.getCell(new Position(mapHeight, mapWidth))
									.getTraveller().toString() == "v") {
						this.character = (Character) this.map.getCell(
								new Position(mapHeight, mapWidth))
								.getTraveller();
						break;
					}
				} catch (OutOfMapException e) {
					// Never reached because of for loop.
					e.printStackTrace();
				}
			}
			if (this.character != null)
				break;
		}
	}

	/**
	 * @return true if all the Blocks are on Targets.
	 */
	public boolean isWon() {
		for (int index = 0; index < this.map.getNumberOfBlocks(); index++) {
			try {
				if (!(this.map.getCell(
						this.map.getBlock(index).getPositionTrav())
						.getOverlay() instanceof Target))
					return false;
			} catch (OutOfMapException e) {
				// Blocks are alway in the map
				e.printStackTrace();
			}

		}
		return true;
	}

	/**
	 * Game engine. Loops until the game is won.
	 */
	public void play() {

		view.play();
	}


	/**
	 * @param direction
	 *            which direction to check.
	 * @param range
	 *            distance from the Character
	 * @return the Traveller standing on the Nth Cell from the Character in the
	 *         given direction.
	 * @see RelativePos
	 */
	private Traveller getTravellerFromCharInDirectionAtRangeN(
			RelativePos direction, int range) {
		try {
			return this.map.getCell(
					this.character.getPositionTrav()
							.generatePosFromRelativeAtRangeN(direction, range))
					.getTraveller();
		} catch (OutOfMapException e) {
			return null;
		}
	}

	/**
	 * Checks if the move given by the player is achievable.
	 * 
	 * @param direction
	 *            Moving Direction chosen by the player.
	 * @return true if possible.
	 */
	public boolean isCharacterMovable(RelativePos direction) {
		Traveller travCellPlusOne = this
				.getTravellerFromCharInDirectionAtRangeN(direction, 1);
		Traveller travCellPlusTwo = this
				.getTravellerFromCharInDirectionAtRangeN(direction, 2);
		if (travCellPlusOne != null && travCellPlusTwo != null) {
			if (travCellPlusOne.isBlock() && travCellPlusTwo.isBlock()) {
				return false;
			}
		}
		try {
			return this.map.isAccessibleFrom(this.character.getPositionTrav(),
					this.character.posToCheck(direction));
		} catch (OutOfMapException e) {
			return false;
		}
	}

	/**
	 * @return this.map .
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @return this.character .
	 */
	public Character getCharacter() {
		return character;
	}

	/**
	 * Prints the Map.
	 */
	@Override
	public String toString() {
		return map.toString();
	}
}
