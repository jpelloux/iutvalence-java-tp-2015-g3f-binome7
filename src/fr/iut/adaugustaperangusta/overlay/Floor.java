package fr.iut.adaugustaperangusta.overlay;

/* TODO Translate. */
/**
 * Sol praticable.
 * Le Character peut se déplacer et pousser des Blocks dessus.
 *
 * @author TODO
 * @version TODO
 */

public class Floor implements Overlay
{
	
	@Override
	public boolean isAccessible()
	{
		return true; 
		
	}

	/**
	 * Méthode d'affichage.
	 * Affiche un espace sur la sortie standard.
	 * Ce caractère s'affiche deux fois dans chaque case.
	 * Exemple : | v |
	 */
	@Override
	public String toString()
	{
		return " ";
	}
}
