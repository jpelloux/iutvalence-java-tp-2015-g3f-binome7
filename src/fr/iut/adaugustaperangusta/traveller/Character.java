/**
 * tous les objets en mouvement sur la map.
 */
package fr.iut.adaugustaperangusta.traveller;

/**
 * Character : personnage jouable pouvant pousser les Blocks.
 */
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
