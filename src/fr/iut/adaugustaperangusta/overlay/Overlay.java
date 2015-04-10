package fr.iut.adaugustaperangusta.overlay;

/* TODO Ceci est un marqueur, c'est très inélégant en terme de POO (surtout ici). */
/* TODO Votre choix d'utiliser une hierarchie de classes plutôt qu'un simple enum est très discutable. */
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
