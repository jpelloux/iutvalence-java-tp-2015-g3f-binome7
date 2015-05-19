package fr.iut.adaugustaperangusta.utils;

import fr.iut.adaugustaperangusta.core.Map;

/**
 * A simple class to test {@link CreateMap}.
 *
 * @author jpelloux
 * @version 1.0.0
 */
public final class CreateMapTestCmd {
    /**
     * Main method.
     *
     * @param args useless
     */
    public static void main(final String... args) {
        Map map = CreateMap.importFromFile("Test.txt");
        System.out.println(map);
        
    }
}
