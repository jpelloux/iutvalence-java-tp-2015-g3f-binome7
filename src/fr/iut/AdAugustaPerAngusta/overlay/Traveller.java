package fr.iut.AdAugustaPerAngusta.overlay;

import fr.iut.AdAugustaPerAngusta.Position;

public abstract class Traveller implements Overlay{
	
	private Position position;
	
	public Position getPosition()
	{
		return this.position;
	}
	
}
