package fr.iut.adaugustaperangusta;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;
import fr.iut.adaugustaperangusta.traveller.Traveller;


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
	
	
	/* TODO JAVADOC. */
	public boolean isWon()
	{
		for(int index =0 ; index < this.map.getNumberOfBlocks(); index++)
		{
			if(!(this.map.getCell(this.map.getBlock(index).getPositionTrav()).getOverlay() instanceof Target)) return false;

		}
		return true;
	}
	
	/* TODO JAVADOC. */
	public void play()
	{
		
		RelativePos dirDeptTest = null;
		System.out.println(this.map);

		while(!(this.isWon()))
		{
			dirDeptTest = this.getMove();
			
			if (this.isMovable(dirDeptTest))
			{
				this.map.moveTrav(this.character.getPositionTrav(), this.character.posToCheck(dirDeptTest)); //tableau
				this.character.move(dirDeptTest);//positions
				
			} else
			{
				System.out.println("-------------");
				System.out.println("Dpt imp"); // Test moche
				System.out.println(dirDeptTest);
				System.out.println(this.character.getPositionTrav());
				System.out.println(this.character.posToCheck(dirDeptTest));
			}
			
			System.out.println(this.map);
			
		}
		System.out.println("Good Job!");

	}
	
	/* TODO JAVADOC. */
	public RelativePos getMove()
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String mouvement = sc.nextLine();  // simplifier?
			char charMvt = mouvement.charAt(0);
	
			switch (charMvt)
			{
			case 'z':
				return RelativePos.NORTH;
			case 'q':
				return RelativePos.WEST;
			case 's':
				return RelativePos.SOUTH;
			case 'd':
				return RelativePos.EAST;
			default:
				System.out.println("Invalid Input"); 
			}
		}
	}
	
	/* TODO JAVADOC. */
	private Traveller getTravellerFromCharInDirectionAtRangeN(RelativePos direction,int range)
	{
		System.out.println(this.map.getCell(this.character.getPositionTrav().generatePosFromRelativeAtRangeN(direction,range)).getTraveller());
		return this.map.getCell(this.character.getPositionTrav().generatePosFromRelativeAtRangeN(direction,range)).getTraveller();
	}
	
	/* TODO JAVADOC. */
	private boolean isMovable(RelativePos direction)
	{
		Traveller travCellPlusOne = this.getTravellerFromCharInDirectionAtRangeN(direction, 1);
		Traveller travCellPlusTwo = this.getTravellerFromCharInDirectionAtRangeN(direction, 2);
		if(travCellPlusOne != null && travCellPlusTwo != null)
		{
			if(travCellPlusOne.isBlock() && travCellPlusTwo.isBlock())
			{
				return false;
			}
		}
		return this.map.isAccessibleFrom(this.character.getPositionTrav(), this.character.posToCheck(direction));	
	}
	
	/* TODO JAVADOC. */
    @Override
    public String toString() {
        return map.toString();
    }
}
