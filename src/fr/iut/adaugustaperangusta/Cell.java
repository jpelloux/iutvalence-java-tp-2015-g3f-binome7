package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.*;
import fr.iut.adaugustaperangusta.traveller.*;

/**
 * Cell dividing the Map. Contains 0 or 1 Overlay. Contains 0 or 1 Traveller.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Cell
{
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
	public Cell(Overlay over, Traveller trav)
	{
		this.cellOverlay = over;
		this.cellTraveller = trav;
	}

	/**
	 * Cell's constructor without parameters. Creates a void Cell, without
	 * Overlay nor Traveller.
	 */
	public Cell()
	{
		this(null, null);
	}

	/**
	 * Cell's constructor without Traveller. Creates a Cell with only an
	 * Overlay.
	 *
	 * @param over
	 *            Overlay standing on the Cell. May be null.
	 */
	public Cell(Overlay over)
	{
		this(over, null);
	}

	/**
	 * Traveller getter.
	 *
	 * @return Traveller the Traveller standing on the Cell.
	 */
	public Traveller getTraveller()
	{
		return this.cellTraveller;
	}

	/**
	 * Traveller setter.
	 * 
	 * @param cellTraveller
	 *            change this.cellTraveller to cellTravel
	 */
	public void setCellTraveller(Traveller cellTraveller)
	{
		this.cellTraveller = cellTraveller;
	}

	/**
	 * Overlay getter.
	 *
	 * @return Overlay the Overlay standing on the Cell.
	 */
	public Overlay getOverlay()
	{
		return this.cellOverlay;
	}

	/**
	 * Walkability test. Must be called before a Traveller's move.
	 *
	 * @return true if the Cell is accessible, false otherwise.
	 */
	public boolean isAccessible()
	{
		// TODO tenter une autre technique que instanceof.
		// if (this.cellOverlay == null || this.cellOverlay instanceof Wall ||
		// this.cellTraveller != null)
		if (this.cellOverlay == null || this.cellOverlay.toString() == "W" || this.cellTraveller != null)
			return false;
		return true;

		// TODO isAccessible : rendre accessible les Cell contenant un Block
	}

	/**
	 * toString redefinition Returns 3 characters, in the form
	 * "Overlay Traveller Overlay". A null Overlay is represented by "/". A null
	 * Traveller is represented by a space.
	 */
	public String toString()
	{
		// TODO utiliser un StringBuffer/StringBuilder
		String str = new String();

		str += this.cellOverlay == null ? "/" : this.cellOverlay.toString();
		str += this.cellTraveller == null ? " " : this.cellTraveller.toString();
		str += this.cellOverlay == null ? "/" : this.cellOverlay.toString();

		return str;
	}
}
