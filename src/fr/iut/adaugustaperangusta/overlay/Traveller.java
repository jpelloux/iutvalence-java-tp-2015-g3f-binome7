/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta.overlay;

import fr.iut.adaugustaperangusta.Position;

public abstract class Traveller implements Overlay {

    private Position position;

    public Position getPosition() {
        return this.position;
    }

}
