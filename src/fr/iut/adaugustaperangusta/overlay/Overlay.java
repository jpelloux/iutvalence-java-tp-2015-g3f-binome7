package fr.iut.adaugustaperangusta.overlay;

import fr.iut.adaugustaperangusta.RelativePos;

/**
 * Elements structuring the Map.
 * Interface. Super-classe of fixed elements of the Map (Floor, Wall et Target)
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
