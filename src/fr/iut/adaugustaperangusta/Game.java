package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.traveller.Character;


/**
 * Game using a Map.
 *
 * @author jpelloux & Axce
 * @version 1.0.0
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
        this.implementPlayer(character);
    }

    private void implementPlayer(Character player)
	{
		this.map.getCell(player.getPositionTrav()).setCellTraveller(player);
		player.setMapTrav(this.map);
		
	}

	/* TODO JAVADOC. */
    public void print() {
        System.out.println(this);
    }
    
    /* TODO JAVADOC. */
    public Map getMap()
	{
		return map;
	}

    /* TODO JAVADOC. */
	public void setMap(Map map)
	{
		this.map = map;
	}

	/* TODO JAVADOC. */
	public Character getCharacter()
	{
		return character;
	}

	/* TODO JAVADOC. */
	public void setCharacter(Character character)
	{
		this.character = character;
	}
	
	public boolean isWin()
	{
		for(int index =0 ; index < this.map.getNumberOfBlocks(); index++)
		{
			if(!(this.map.getCell(this.map.getBlock(index).getPositionTrav()).getOverlay() instanceof Target)) return false;

		}
		return true;
	}
    @Override
    public String toString() {
        return map.toString();
    }
}
