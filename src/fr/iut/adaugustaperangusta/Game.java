package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.traveller.Character;

/* TODO Translate. */

/**
 * Partie contenant une Map.
 *
 * @author TODO
 * @version TODO
 */
public class Game {
    /* TODO JAVADOC. */
    private Map       map;
    /* TODO JAVADOC. */
    private Character character;

    /* TODO JAVADOC. */
    public Game(Map map, Character character) {
        this.map = map;
        this.character = character;
    }

    /* TODO JAVADOC. */
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
