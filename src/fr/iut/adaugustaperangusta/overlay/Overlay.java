package fr.iut.adaugustaperangusta.overlay;

/**
 * Éléments constituant la Map.
 * Interface. Super-classe de tous les éléments fixes de la map.
 * Floor, Wall et Target en sont héritées.
 */
public interface Overlay
{
	/**
	 * Availability test.
	 * 
	 * @return <True> if walkable by travellers  
	 */
	public boolean isAccessible();
}
