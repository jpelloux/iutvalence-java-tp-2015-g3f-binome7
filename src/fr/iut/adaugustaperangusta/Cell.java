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

	public Cell()
	{
		this(null, null);
	}

	public Cell(Overlay over)
	{
		this(over, null);
	}

	public Cell(Traveller trav)
	{
		this(null, trav);
	}
	
	/* TODO JAVADOC. */
	private boolean isAccessible()
	{
		/* TODO Pour votre culture il est à proscrire les instanceof en programmation objet, il faut les utiliser le
			moins souvent possible.
		 */
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
