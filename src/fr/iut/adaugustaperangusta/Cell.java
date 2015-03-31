/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Overlay;
import fr.iut.adaugustaperangusta.overlay.VoidOverlay;
import fr.iut.adaugustaperangusta.traveller.Traveller;

/* TODO JAVADOC. */
public class Cell
{
	/* Une Cell (case abstraite) contient :
	 * 0 ou 1 Overlay (case concrète de la map (sol, mur, target))
	 * 0 ou 1 Traveller (Character ou Block)
	 */
	/* TODO JAVADOC. */
	private Overlay		cellOverlay;
	private Traveller	cellTraveller;
	
	/* TODO JAVADOC. */
	public Cell()
	{
		this.cellOverlay = new VoidOverlay();
		//TODO supprimer VoidOverlay et VoidTraveller et les remplacer par null
	}
	
	/* TODO JAVADOC. */
	public Cell(Overlay content)
	{
		this.cellOverlay = content;
	}
	
	// TODO Meilleurs constructeurs, pour mettre un Traveller sur la Cell
	
	/* TODO JAVADOC. */
	private boolean isAccessible()
	{
		return true;
		// TODO isAccessible
	}
	
	/* TODO JAVADOC. */
	public String toString()
	{
		// return "   ";
		return this.cellOverlay.toString();
		// TODO toString : pouvoir afficher les travellers
	}
}
