package fr.iut.adaugustaperangusta.traveller;

import fr.iut.adaugustaperangusta.Position;

/* TODO Translate. */
/**
 * Personnage jouable.
 * Il peut pousser les Blocks.
 *
 * @author TODO
 * @version TODO
 */
public class Character extends Traveller
{
	/* TODO In Traveler ? */
	/* TODO Translate. */
	/** Nom du Character. */
	private String	name;

	
	/* TODO Translate. */
	/**
	 * Constructeur Character.
	 * 
	 * @param name	le nom du personnage.
	 * @param pos   la position du personnage
	 */
	public Character(String name, Position pos)
	{
		this.name= name;
		this.positionTrav= pos;
	}

	/* TODO In Traveller ? */
	/* TODO Translate. */
	/**
	 * Getter du nom.
	 * 
	 * @return Le nom du Character.
	 */
	@Override
	public String getName()
	{
		return this.name;
	}

	/* TODO Translate. */
	/**
	 * Méthode d'affichage.
	 * Affiche le caractère 'v' sur la sortie standard.
	 * Ce caractère s'affiche au centre de chaque case.
	 */
	@Override
	public String toString()
	{
		return "v";
	}
	
}
