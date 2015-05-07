package fr.iut.adaugustaperangusta.overlay;

/**
 * Unaccessible Wall.
 * The Character and Blocks can't walk through it.
 * A Map must be surounded by Walls.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Wall implements Overlay
{
	/**
	 * A Wall is unaccessible.
	 */
	@Override
	public boolean isAccessible()
	{
		return false;
	}

	/**
     * Display method.
     * Prints 'W' on standard output.
     * Is displayed twice for each Cell.
     * Example : |W W|
	 */
	public String toString()
	{
		return "W";
	}
	
}
