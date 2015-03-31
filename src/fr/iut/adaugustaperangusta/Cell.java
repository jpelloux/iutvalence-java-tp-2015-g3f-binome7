/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Overlay;
import fr.iut.adaugustaperangusta.overlay.VoidCell;

/* TODO JAVADOC. */
public class Cell
{
	/* TODO Pourquoi passer par 50 classes d'Overlay et pas par un enum ? */
	/*
	 * TODO Si l'enum ne vous tente pas, pourquoi les classes d'Overlay ne sont
	 * pas des Cell (par héritage) ?
	 */
	/* TODO JAVADOC. */
	private Overlay	cellContent;
	
	/* TODO JAVADOC. */
	public Cell()
	{
		this.cellContent = new VoidCell();
	}
	
	/* TODO JAVADOC. */
	public Cell(Overlay content)
	{
		this.cellContent = content;
	}
	
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
		return this.cellContent.toString();
	}
}
