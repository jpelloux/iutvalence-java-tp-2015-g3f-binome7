package fr.iut.adaugustaperangusta.overlay;

/* TODO Translate. */

/**
 * Éléments constituant la Map.
 * Interface. Super-classe de tous les éléments fixes de la map.
 * Floor, Wall et Target en sont héritées.
 *
 * @author TODO
 * @version TODO
 */
public interface Overlay {
    /**
     * Availability test.
     *
     * @return <True> if walkable by travellers
     */
    boolean isAccessible();
}
