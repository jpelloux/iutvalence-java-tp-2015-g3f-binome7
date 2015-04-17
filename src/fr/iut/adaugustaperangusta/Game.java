package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Target;
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
		if(this.map.getCell(this.map.getBlock().getPositionTrav()).getOverlay() instanceof Target) return true;
		return false;
	}
    @Override
    public String toString() {
        return map.toString();
    }
}
