package fr.iut.adaugustaperangusta.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fr.iut.adaugustaperangusta.core.Cell;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.Position;
import fr.iut.adaugustaperangusta.core.overlay.Floor;
import fr.iut.adaugustaperangusta.core.overlay.Target;
import fr.iut.adaugustaperangusta.core.overlay.Wall;
import fr.iut.adaugustaperangusta.core.traveller.Block;
import fr.iut.adaugustaperangusta.core.traveller.Character;

/**
 * Small utility class to import {@link Map} from an UTF-8 text file.
 *
 * @author jpelloux
 * @version 2.0.0
 * @see Map
 * @see Floor
 * @see Target
 * @see Wall
 * @see Block
 * @see Character
 */
public final class CreateMap {
    /** Empty constructor. */
    private CreateMap() { /* NOTHING */ }

    /**
     * Import a {@link Map} from an UTF-8 text file.
     * <p>
     * <b>Warning:</b> this method believes in the headers of the file.
     * <p>
     * File format:<br>
     * HEIGHT (int)<br>
     * WIDTH  (int)<br>
     * NB Of block (int)<br>
     * MAP (respecting the above header)<br>
     *
     * @param filename source file.
     *
     * @return Map or NULL.
     *
     * @see CreateMap#generateCellFromCharacter(char, int, int)
     */
    public static Map importFromFile(final String filename) {
        final Map map;
        try (final BufferedReader fis = new BufferedReader(new FileReader(filename))) {
            /* Get the map size. */
            final int height = Integer.parseInt(fis.readLine());
            final int width = Integer.parseInt(fis.readLine());
            final int nbOfBlock = Integer.parseInt(fis.readLine());
            map = new Map(height, width,nbOfBlock);

            /* Parse the map. */
            int lineIdx = 0;
            String line;
            /* For each line. */
            while ((line = fis.readLine()) != null) {
                int colIdx = 0;
                /* In each line, for each byte. */
                for (final byte b : line.getBytes("UTF-8")) {
                    /* Skip EOL. */
                    if ((b == '\r') || (b == '\n')) {
                        continue;
                    }

                    /* Handle real chars. */
                    final Cell cell = generateCellFromCharacter((char) b, colIdx, lineIdx,map);

                    /* WARNING: We believe in the size in the header. */
                    map.setCell(lineIdx, colIdx, cell);
                    colIdx++;
                }
                lineIdx++;
            }
        }
        catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    /**
     * Converts a character into a {@link Cell}.
     * <p>
     * Conversion map:
     * <ul>
     * <li>x -> Wall</li>
     * <li>o -> Target</li>
     * <li>b -> Block</li>
     * <li>v -> Character("Unknown", Position(x,y),map)</li>
     * <li>others -> Floor</li>
     * </ul>
     *
     * @param c The character.
     * @param x The 'x' position of the Cell in the final map.
     * @param y The 'y' position of the Cell in the final map.
     * @param map The map we are creating.
     * @return The generated Cell.
     */
    private static Cell generateCellFromCharacter(final char c, final int x, final int y,Map map) {
        switch (c) {
            case 'x':
                return new Cell(new Wall());
            case 'o':
                return new Cell(new Target());
            case 'b':
                map.setBlock(new Block(new Position(y, x),map,map.getActualNumberOfBlocks()),map.getActualNumberOfBlocks());
               map.setActualNumberOfBlocks(map.getActualNumberOfBlocks() +1);
            	return new Cell(new Floor(), map.getBlock(map.getActualNumberOfBlocks() -1));
            case 'v':
                return new Cell(new Floor(), new Character("Unknown", new Position(y, x),map));
            default:
                return new Cell(new Floor());
        }
    }
}

