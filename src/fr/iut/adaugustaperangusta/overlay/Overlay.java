package fr.iut.adaugustaperangusta.overlay;

import fr.iut.adaugustaperangusta.RelativePos;

/* TODO Translate. */

/**
 * Éléments constituant la Map.
 * Interface. Super-classe de tous les éléments fixes de la map.
 * Floor, Wall et Target en sont héritées.
 *
 * @author jpellou and Axce
 * @version 1.0.0
 */
public interface Overlay {
    /**
     * Availability test.
     *
     * @return <True> if walkable by travellers
     */
    boolean isAccessible();

}
