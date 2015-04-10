package fr.iut.adaugustaperangusta.overlay;

/**
 * Mur impraticable.
 * Le Character et les Blocks ne peuvent pas les traverser.
 * Ils délimitent la Map.
 */
public class Wall implements Overlay
{
	
	@Override
	public boolean isAccessible()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Méthode d'affichage.
	 * Affiche le caractère 'W' sur la sortie standard.
	 * Ce caractère s'affiche deux fois dans chaque case.
	 * Exemple : |W W|
	 */
	public String toString()
	{
		return "W";
	}
	
}
