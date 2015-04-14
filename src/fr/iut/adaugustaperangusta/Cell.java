package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.*;
import fr.iut.adaugustaperangusta.traveller.*;

/* TODO Translate. */
/**
 * Case divisant la Map.
 * Elle contient 0 ou 1 Overlay.
 * Elle contient 0 ou 1 Traveller.
 *
 * @author TODO
 * @version TODO
 */
public class Cell
{
    /* TODO Translate. */
	/**
	 * Overlay présent sur la Cell.
	 * Peut valoir null.
	 */
	private Overlay		cellOverlay;

    /* TODO Translate. */
	/**
	 * Traveller présent sur la Cell.
	 * Peut valoir null.
	 */
	private Traveller	cellTraveller;

    /* TODO Translate. */
	/**
	 * Constructeur Cell.
	 *
	 * @param over L'Overlay présent sur la Cell. Peut valoir null.
	 * @param trav Le Traveller présent sur la Cell. Peut valoir null.
	 */
	public Cell(Overlay over, Traveller trav)
	{
		this.cellOverlay = over;
		this.cellTraveller = trav;
	}

    /* TODO Translate. */
	/**
	 * Constructeur vide Cell.
	 * Il crée une Cell vide, sans Overlay ni Traveller.
	 */
	public Cell()
	{
		this(null, null);
	}

    /* TODO Translate. */
	/**
	 * Constructeur Cell sans Traveller.
	 * Il crée une Cell contenant un Overlay.
	 *
	 * @param over L'Overlay présent sur la Cell. Peut valoir null.
	 */
	public Cell(Overlay over)
	{
		this(over, null);
	}

    /* TODO Translate. */
	/**
	 * Donne le traveller posé sur la cellule courante.
	 *
	 * @return Traveller le traveller sur la cellule courante.
	 */
	public Traveller getTraveller()
	{
		return this.cellTraveller;
	}
	
	

    public void setCellTraveller(Traveller cellTraveller)
	{
		this.cellTraveller = cellTraveller;
	}

	/* TODO Translate. */
	/**
	 * Donne l'overlay posé sur la cellule courante.
	 *
	 * @return Overlay l'overlay sur la cellule courante.
	 */
	public Overlay getOverlay()
	{
		return this.cellOverlay;
	}

    /* TODO Translate. */
	/**
	 * Test de praticabilité.
	 * Doit être appelée avant le déplacement d'un Character.
	 *
	 * @return true si la Cell est praticable, false sinon.
	 */
	public boolean isAccessible()
	{
		// TODO tenter une autre technique que instanceof.
		if (this.cellOverlay == null || this.cellOverlay instanceof Wall
				|| this.cellTraveller != null)
			return false;
		return true;

		// TODO isAccessible : rendre accessible les Cell contenant un Block
	}

	/**
	 * Méthode d'affichage.
	 * Renvoie trois caractère, sous la forme "Overlay Traveller Overlay".
	 * Un Overlay null est représenté par le caractère "/".
	 * Un Traveller null est représenté par un espace.
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
