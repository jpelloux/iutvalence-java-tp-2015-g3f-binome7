/**
 * Objets en mouvement.
 */
package fr.iut.adaugustaperangusta.traveller;

/**
 * Personnage jouable.
 * Il peut pousser les Blocks.
 */
public class Character extends Traveller
{
	/**
	 * Nom du Character.
	 */
	private String	name;
	
	/**
	 * Constructeur Character.
	 * 
	 * @param name	le nom du personnage.
	 */
	public Character(String name)
	{
		this.name= name;
	}

	/**
	 * Getter du nom.
	 * 
	 * @return Le nom du Character.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Méthode d'affichage.
	 * Affiche le caractère 'v' sur la sortie standard.
	 * Ce caractère s'affiche au centre de chaque case.
	 */
	public String toString()
	{
		return "v";
	}
	
}
