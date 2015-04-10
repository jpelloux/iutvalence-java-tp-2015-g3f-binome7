package fr.iut.adaugustaperangusta.overlay;

/**
 * Sol praticable.
 * Le Character peut se déplacer et pousser des Blocks dessus.
 */
public class Floor implements Overlay
{
	@Override
	public boolean isAccessible()
	{
		// TODO Auto-generated method stub
		return false;
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
