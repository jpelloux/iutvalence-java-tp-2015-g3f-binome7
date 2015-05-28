package fr.iut.adaugustaperangusta.core;

import fr.iut.adaugustaperangusta.core.overlay.Overlay;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;

/**
 * Cell dividing the Map. Contains 0 or 1 Overlay. Contains 0 or 1 Traveller.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Cell {
	/**
	 * Overlay standing on the Cell. May be null.
	 */
	private Overlay cellOverlay;

	/**
	 * Traveller standing on the Cell. May be null.
	 */
	private Traveller cellTraveller;

	/**
	 * Cell's constructor.
	 *
	 * @param over
	 *            Overlay standing on the Cell. May be null.
	 * @param trav
	 *            Traveller standing on the Cell. May be null.
	 */
	public Cell(Overlay over, Traveller trav) {
		this.cellOverlay = over;
		this.cellTraveller = trav;
	}

	/**
	 * Cell's constructor without parameters. Creates a void Cell, without
	 * Overlay nor Traveller.
	 */
	public Cell() {
		this(null, null);
	}

	/**
	 * Cell's constructor without Traveller. Creates a Cell with only an
	 * Overlay.
	 *
	 * @param over
	 *            Overlay standing on the Cell. May be null.
	 */
	public Cell(Overlay over) {
		this(over, null);
	}

	/**
	 * Traveller getter.
	 *
	 * @return Traveller the Traveller standing on the Cell.
	 */
	public Traveller getTraveller() {
		return this.cellTraveller;
	}

	/**
	 * Traveller setter.
	 * 
	 * @param cellTraveller
	 *            change this.cellTraveller to cellTravel
	 */
	public void setCellTraveller(Traveller cellTraveller) {
		this.cellTraveller = cellTraveller;
	}

	/**
	 * Overlay getter.
	 *
	 * @return Overlay the Overlay standing on the Cell.
	 */
	public Overlay getOverlay() {
		return this.cellOverlay;
	}

	/**
	 * Walkability test. Must be called before a Traveller's move.
	 *
	 * @return true if the Cell is accessible, false otherwise.
	 */
	public boolean isAccessible() {
		return this.cellOverlay != null && this.cellTraveller == null
				&& !this.cellOverlay.isAccessible();
	}

	/**
	 * toString redefinition Returns 3 characters, in the form
	 * "Overlay Traveller Overlay". A null Overlay is represented by "/". A null
	 * Traveller is represented by a space.
	 */
	@Override
	public String toString() {
		return String.format("%s%s%s", this.cellOverlay == null ? "/"
				: this.cellOverlay.toString(), this.cellTraveller == null ? " "
				: this.cellTraveller.toString(), this.cellOverlay == null ? "/"
				: this.cellOverlay.toString());
	}
}
