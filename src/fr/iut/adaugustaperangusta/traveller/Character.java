/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta.traveller;

public class Character extends Traveller
{
	
	private String	name;
	
	public Character(String name)
	{
		this.name= name;
	}

	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return "v";
	}
	
}
