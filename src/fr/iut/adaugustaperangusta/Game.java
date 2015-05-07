package fr.iut.adaugustaperangusta;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;
import fr.iut.adaugustaperangusta.traveller.Traveller;


/**
 * Class containing the attributes of one game.
 *
 * @author jpelloux and Axce
 * @version 1.1.0
 */
public class Game {

	/**
	 * Map used for the Game.
	 */
	private Map       map;

	/**
	 * Character used for the Game.
	 */
    private Character character;

    /**
     * Game constructor.
     * Sets the map to be solved.
     */
    public Game(Map map)
    {
        this.map = map;
        this.character = null;
        this.implementPlayer();
    }

    /**
     * Search for the Character into the Map to put it into the <tt>character</tt> field.
     */
    private void implementPlayer()
	{
    	for(int mapHeight=0; mapHeight < this.map.getHeight();mapHeight++)
    	{
    		for(int mapWidth=0; mapWidth < this.map.getWidth();mapWidth++)
        	{
        		if(this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller() != null 
        				&& this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller().toString() =="v")
        		{
        			this.character=(Character) this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller();
        			break;
        		}
        	}
    		if(this.character != null) break;
    	}	
	}
    
    /**
     * @return true if all the Blocks are on Targets.
     */
    public boolean isWon()
	{
		for(int index =0 ; index < this.map.getNumberOfBlocks(); index++)
		{
			if(!(this.map.getCell(this.map.getBlock(index).getPositionTrav()).getOverlay() instanceof Target)) return false;

		}
		return true;
	}
	
    /**
     * Game engine.
     * Loops until the game is won.
     */
	public void play()
	{
		
		RelativePos dirDeptTest = null;
		System.out.println(this.map);

		while(!(this.isWon()))
		{
			dirDeptTest = this.getMove();
			
			if (this.isCharacterMovable(dirDeptTest))
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
	
	/**
	 * Converts a <tt>char</tt> (z,q,s,d) into a RelativePos.
	 * @return the player's next move.
	 * @see RelativePos
	 */
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
				System.out.println("Invalid Input"); 	//TODO Exception (quit game)
			}
		}
	}
	
	/**
	 * @param direction which direction to check.
	 * @param range distance from the Character
	 * @return the Traveller standing on the Nth Cell from the Character in the given direction.
	 * @see RelativePos
	 */
	private Traveller getTravellerFromCharInDirectionAtRangeN(RelativePos direction,int range)
	{
		System.out.println(this.map.getCell(this.character.getPositionTrav().generatePosFromRelativeAtRangeN(direction,range)).getTraveller());
		return this.map.getCell(this.character.getPositionTrav().generatePosFromRelativeAtRangeN(direction,range)).getTraveller();
	}
	
	/**
	 * Checks if the move given by the player is achievable.
	 * @param direction Moving Direction chosen by the player.
	 * @return true if possible.
	 */
	private boolean isCharacterMovable(RelativePos direction)
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
	
	/**
	 * Prints the Map.
	 */
    @Override
    public String toString() {
        return map.toString();
    }
}
