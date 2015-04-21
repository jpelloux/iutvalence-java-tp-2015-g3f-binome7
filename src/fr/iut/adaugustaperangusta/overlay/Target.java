package fr.iut.adaugustaperangusta.overlay;

/* TODO "implements Overlay" or "extends Floor"? */
/* TODO Translate. */

/**
 * Cible accueillant un Block.
 * Le Character peut se déplacer et pousser des Blocks dessus.
 * Le but est d'amener tous les Blocks sur ces Targets.
 *
 * @author jpelloux and Axce
 * @version 1.0.0
 */
public class Target implements Overlay {
    @Override
    
    /**
     * La cible est tjr accessible (comme le floor)
     */
    public boolean isAccessible() {
        return true;
    }

    /* TODO Translate. */
    /**
     * Méthode d'affichage.
     * Affiche le caractère '!' sur la sortie standard.
     * Ce caractère s'affiche deux fois dans chaque case.
     * Exemple : |!v!|
     */
    @Override
    public String toString() {
        return "!";
    }
}
