/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.*;
import fr.iut.adaugustaperangusta.traveller.*;

/* TODO JAVADOC. */
public class Cell
{
	/*
	 * Une Cell (case abstraite) contient : 0 ou 1 Overlay (case concrète de la
	 * map (sol, mur, target)) 0 ou 1 Traveller (Character ou Block)
	 */
	/* TODO JAVADOC. */
	private Overlay		cellOverlay;
	private Traveller	cellTraveller;
	
	/* TODO JAVADOC. */
	public Cell(Overlay over, Traveller trav)
	{
		this.cellOverlay = over;
		this.cellTraveller = trav;
	}
	
	public Cell(Traveller trav, Overlay over)
	{
		this.cellTraveller = trav;
		this.cellOverlay = over;
	}
	
	public Cell()
	{
		this.cellOverlay = null;
		this.cellTraveller = null;
	}
	
	public Cell(Overlay over)
	{
		this.cellOverlay = over;
		this.cellTraveller = null;
	}
	
	public Cell(Traveller trav)
	{
		this.cellTraveller = trav;
		this.cellOverlay = null;
	}
	
	// TODO supprimer VoidOverlay et VoidTraveller et les remplacer par null
	/* TODO JAVADOC. */
	private boolean isAccessible()
	{
		if (this.cellOverlay == null || this.cellOverlay instanceof Wall
				|| this.cellTraveller != null)
			return false;
		return true;
		// TODO isAccessible : rendre accessible les Cell contenant un Block
	}
	
	/* TODO JAVADOC. */
	public String toString()
	{
		String str = new String();
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
