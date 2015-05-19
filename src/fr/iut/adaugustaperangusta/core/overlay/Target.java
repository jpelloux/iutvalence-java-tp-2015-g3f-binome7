package fr.iut.adaugustaperangusta.core.overlay;

/**
 * Targets where blocks must be placed.
 * The Character peut can walk and push Blocks on them.
 * The goal is to bring all Blocks on them.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Target implements Overlay {
    @Override
    
    /**
     * Always walkable (like Floor)
     */
    public boolean isAccessible() {
        return true;
    }

    /**
     * Display method.
     * Prints '!' on standard output.
     * Is displayed twice for each Cell.
     * Example : |!v!|
     */
    @Override
    public String toString() {
        return "!";
    }
}
