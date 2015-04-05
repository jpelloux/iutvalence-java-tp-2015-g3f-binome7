/**
 * Objets en mouvement.
 */
package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Position;

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
	 * Position du Character.
	 */
	private Position positionChar;
	/**
	 * Constructeur Character.
	 * 
	 * @param name	le nom du personnage.
	 * @param pos   la position du personnage
	 */
	public Character(String name, Position pos)
	{
		this.name= name;
		this.positionChar= pos;
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
