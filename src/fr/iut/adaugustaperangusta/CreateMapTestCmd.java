package fr.iut.adaugustaperangusta;

/**
 * A simple class to test {@link CreateMap}.
 *
 * @author jpellou
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
