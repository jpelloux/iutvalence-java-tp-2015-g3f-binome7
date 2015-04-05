package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.*;
import fr.iut.adaugustaperangusta.traveller.*;

/**
 * Case divisant la Map.
 * Elle contient 0 ou 1 Overlay.
 * Elle contient 0 ou 1 Traveller.
 */
public class Cell
{
	/**
	 * Overlay présent sur la Cell.
	 * Peut valoir null.
	 */
	private Overlay		cellOverlay;
	
	/**
	 * Traveller présent sur la Cell.
	 * Peut valoir null.
	 */
	private Traveller	cellTraveller;
	
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
	
	/**
	 * Constructeur vide Cell.
	 * Il crée une Cell vide, sans Overlay ni Traveller.
	 */
	public Cell()
	{
		this(null, null);
	}
	
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
	
	/**
	 * Constructeur Cell sans Overlay.
	 * Il crée une Cell contenant un Traveller.
	 * 
	 * @param trav Le Traveller présent sur la Cell. Peut valoir null.
	 */
	public Cell(Traveller trav)
	{
		this(null, trav);
	}
	
	/**
	 * Donne le traveller posé sur la cellule courante.
	 * 
	 * @return Traveller le traveller sur la cellule courante.
	 */
	public Traveller getTraveller()
	{
		return this.cellTraveller;
	}
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
		
		// TODO À simplifier avec des ternaires.
		if (this.cellOverlay == null)
			str += "/";
		else
			str += this.cellOverlay;
		
		if (this.cellTraveller == null)
			str += " ";
		else
			str += this.cellTraveller;
		
		if (this.cellOverlay == null)
			str += "/";
		else
			str += this.cellOverlay;
		
		return str;
	}
}
