package fr.iut.adaugustaperangusta.overlay;

/**
 * Cible accueillant un Block.
 * Le Character peut se déplacer et pousser des Blocks dessus.
 * Le but est d'amener tous les Blocks sur ces Targets.
 */
public class Target implements Overlay
{	
	
	@Override
	public boolean isAccessible()
	{
		return true;
	}
	
	/**
	 * Méthode d'affichage.
	 * Affiche le caractère '!' sur la sortie standard.
	 * Ce caractère s'affiche deux fois dans chaque case.
	 * Exemple : |!v!|
	 */
	@Override
	public String toString()
	{
		return "!";
	}


	
}
