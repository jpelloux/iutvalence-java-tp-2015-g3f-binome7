package fr.iut.adaugustaperangusta.coreModel;

import java.util.Scanner;

import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;
import fr.iut.adaugustaperangusta.traveller.Traveller;
import fr.iut.adaugustaperangusta.view.console.StrDisplay;


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
        		try
				{
					if(this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller() != null 
							&& this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller().toString() =="v")
					{
						this.character=(Character) this.map.getCell(new Position(mapHeight,mapWidth)).getTraveller();
						break;
					}
				} catch (OutOfMapException e)
				{
					// Never reached because of for loop.
					e.printStackTrace();
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
			try  
			{
				if(!(this.map.getCell(this.map.getBlock(index).getPositionTrav()).getOverlay() instanceof Target)) return false;
			} catch (OutOfMapException e)
			{   
				// Blocks are alway in the map
				e.printStackTrace();
			}

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
		StrDisplay.displayMap(this.map);

		while(!(this.isWon()))
		{
			dirDeptTest = this.getMove();
			
			if (this.isCharacterMovable(dirDeptTest))
			{
				
				try
				{
					this.map.moveTrav(this.character.getPositionTrav(), this.character.posToCheck(dirDeptTest));//tableau
					this.character.move(dirDeptTest);//positions
				} catch (OutOfMapException e)
				{
					StrDisplay.displayInvalideMove(dirDeptTest, this.character);
				} 

				
			} else
			{
				StrDisplay.displayInvalideMove(dirDeptTest, this.character);
			}
			StrDisplay.displayMap(this.map);
		}
		StrDisplay.displayWin();
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
			String mouvement = sc.nextLine(); 
			char charMvt;
			if (mouvement.length()>1) continue; // More than 1 char in stdin
			try
			{
				charMvt = mouvement.charAt(0);
	
			} catch (Exception e) // 0 char in stdin
			{
				continue;
			}
	
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
					StrDisplay.displayInvalideInput();
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
		try
		{
			return this.map.getCell(this.character.getPositionTrav().generatePosFromRelativeAtRangeN(direction,range)).getTraveller();
		} catch (OutOfMapException e)
		{
			return null;
		}
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
		try
		{
			return this.map.isAccessibleFrom(this.character.getPositionTrav(), this.character.posToCheck(direction));
		} catch (OutOfMapException e)
		{
			return false;
		}	
	}
	
	/**
	 * Prints the Map.
	 */
    @Override
    public String toString() {
        return map.toString();
    }
}
