package fr.iut.adaugustaperangusta.core.traveller;

import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.Position;
import fr.iut.adaugustaperangusta.core.RelativePos;

/**
 * Moving objects. Super-class of every moving objects on the Map.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public abstract class Traveller {

	/** Traveller's name */
	protected String name;

	/** Traveller's Position. */
	protected Position positionTrav;

	/** Map that is travelled. */
	protected Map mapTrav;

	/**
	 * Traveller's number. used for listing Blocks
	 */
	protected int travNumber;

	/**
	 * Checks is the way is free for the Traveller to be pushed. Only Blocks are
	 * pushable.
	 * 
	 * @param posPlayer
	 *            Position from which the Block is pushed.
	 * @return true if the Block is pushable in the context.
	 * @see RelativePos
	 */
	public abstract boolean isPushableFrom(Position posPlayer);

	/**
	 * Checks if Traveller's instance is also a Block's instance.
	 * 
	 * @return true if it's a Block
	 */
	public abstract boolean isBlock();

	/**
	 * Returns end position of a Blocked being pushed. This position must be
	 * tested for walkability.
	 * 
	 * @param direction
	 *            Direction in which the Block is pushed.
	 * @return end position of a Blocked being pushed.
	 */
	public Position posToCheck(RelativePos direction) {
		return (this.positionTrav.generatePosFromRelative(direction));
	}

	/**
	 * Changes by 1 the Traveller's Position in a given direction (RelativePos).
	 * 
	 * @param direction
	 *            Direction of the Traveller's movement
	 * @see RelativePos
	 */
	public void move(RelativePos direction) {
		this.positionTrav.addRelative(direction);
	}

	/**
	 * @return Traveller's Position.
	 */
	public Position getPositionTrav() {
		return positionTrav;
	}

	/**
	 * @param Traveller
	 *            's Position.
	 */
	public void setPositionTrav(Position positionTrav) {
		this.positionTrav = positionTrav;
	}

	/**
	 * @return Map where the Traveller is.
	 */
	public Map getMapTrav() {
		return mapTrav;
	}

	/**
	 * @return Traveller's number.
	 */
	public int getTravNumber() {
		return this.travNumber;
	}

	/**
	 * @return Traveller's name.
	 */
	public String getName() {
		return this.name;
	}

}
