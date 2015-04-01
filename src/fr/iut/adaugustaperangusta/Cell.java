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

	/* TODO Alors le deuxième constructeur avec les paramètres dans un autre ordre, c'est vraiment horrible ! */
	public Cell(Traveller trav, Overlay over)
	{
		this.cellTraveller = trav;
		this.cellOverlay = over;
	}

	/* TODO Pourquoi ne pas exprimer ce constructeur à l'aide de votre premier ou de votre deuxième constructeur ?
	* (e.g. this(null,null);)
	*/
	public Cell()
	{
		this.cellOverlay = null;
		this.cellTraveller = null;
	}

	/* TODO Pourquoi ne pas exprimer ce constructeur à l'aide de votre premier ou de votre deuxième constructeur ? */
	public Cell(Overlay over)
	{
		this.cellOverlay = over;
		this.cellTraveller = null;
	}

	/* TODO Pourquoi ne pas exprimer ce constructeur à l'aide de votre premier ou de votre deuxième constructeur ? */
	public Cell(Traveller trav)
	{
		this.cellTraveller = trav;
		this.cellOverlay = null;
	}
	
	// TODO supprimer VoidOverlay et VoidTraveller et les remplacer par null
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
