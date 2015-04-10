package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

/**
 * Partie contenant une Map.
 */
public class Game
{
	private Map map;
	
	private Character character;
	
	
	public Game(Map map, Character character)
	{
		this.map= map;
		this.character= character;
	}
		
	public void printGame()
	{
		System.out.println(this);
	}
	
	public String toString()
	{
		return map.toString();
	}

}
