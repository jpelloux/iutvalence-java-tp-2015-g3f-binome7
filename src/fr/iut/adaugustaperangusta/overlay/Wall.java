package fr.iut.adaugustaperangusta.overlay;

/* TODO Translate. */
/**
 * Mur impraticable.
 * Le Character et les Blocks ne peuvent pas les traverser.
 * Ils délimitent la Map.
 *
 * @author TODO
 * @version TODO
 */
public class Wall implements Overlay
{
	@Override
	public boolean isAccessible()
	{
		return false;
	}

	/* TODO Translate. */
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
