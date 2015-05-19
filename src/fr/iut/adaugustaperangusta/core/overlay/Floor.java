package fr.iut.adaugustaperangusta.core.overlay;

/**
 * Ground you can travel on.
 * The Character can move and push blocks on it
 * 
 * @author jpelloux and cearda
 * @version 1.1.0
 */

public class Floor implements Overlay
{
	/**
	 * A Cell is alway reachable
	 */
	@Override
	public boolean isAccessible()
	{
		return true; 
	}

	/**
	 * Display method.
	 * Print a space on standart output
	 * This char is print twice in each cell.
	 * Example : | v |
	 */
	@Override
	public String toString()
	{
		return " ";
	}
}
