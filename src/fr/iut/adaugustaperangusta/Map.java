/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Block;
import fr.iut.adaugustaperangusta.overlay.Character;
import fr.iut.adaugustaperangusta.overlay.Empty;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;

/* TODO JAVADOC. */
public class Map {
    /* TODO JAVADOC. */
    private static final int DEFAULT_HEIGHT = 15;
    /* TODO JAVADOC. */
    private static final int DEFAULT_WIDTH = 10;

    /* TODO JAVADOC. */

    private final int height;
    /* TODO JAVADOC. */

    private final int width;
    /* TODO JAVADOC. */

    private final Cell[][] tabCell;

    /* TODO JAVADOC. */
    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        this.tabCell = new Cell[height][width];
        for (int cellHeight = 0; cellHeight < height; cellHeight++) {
            for (int cellWidth = 0; cellWidth < width; cellWidth++) {
                tabCell[cellHeight][cellWidth] = new Cell();
            }
        }
    }

    /* TODO JAVADOC. */
    public Map() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /* TODO À quoi sert le paramètre ? */
    /* TODO JAVADOC. */
    public Map(char devTest) {
        this.width = 4;
        this.height = 2;
        this.tabCell = new Cell[height][width];
        this.tabCell[0][0] = new Cell();
        this.tabCell[0][1] = new Cell(new Wall());
        this.tabCell[0][2] = new Cell(new Character());
        this.tabCell[0][3] = new Cell(new Target());
        this.tabCell[1][0] = new Cell(new Empty());
        this.tabCell[1][1] = new Cell(new Empty());
        this.tabCell[1][2] = new Cell(new Block());
        this.tabCell[1][3] = new Cell(new Target());
    }

    @Override
    public String toString() {
        /* TODO Discuter en séance (ou à regarder par vous même) : String vs StringBuffer vs StringBuilder. */
        String str = new String();
        str += "-";
        for (int i = 0; i < this.width; i++) { str += "----"; }
        str += "\n";

        for (int cellHeight = 0; cellHeight < this.height; cellHeight++) {
            for (int cellWidth = 0; cellWidth < this.width; cellWidth++) {
                str = str + "|" + this.tabCell[cellHeight][cellWidth];
            }
            str += "|\n-";
            for (int i = 0; i < this.width; i++) { str += "----"; }
            str += "\n";
        }

        return str;
    }
}
