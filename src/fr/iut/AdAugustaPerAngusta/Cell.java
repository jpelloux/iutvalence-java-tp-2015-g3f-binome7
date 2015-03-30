package fr.iut.AdAugustaPerAngusta;

import fr.iut.AdAugustaPerAngusta.overlay.*;

public class Cell
{
	private Overlay cellContent;
	
	private boolean isAccessible()
	{
		return true;
		//TODO isAccessible
	}
	
	public String toString()
	{
		//return "   ";
		return this.cellContent.toString();
	}
	
	public Cell()
	{
		this.cellContent= new VoidCell();
	}
	
	public Cell(Overlay content)
	{
		this.cellContent= content;
	}
}
