package fr.iut.adaugustaperangusta.core;

import fr.iut.adaugustaperangusta.core.overlay.Floor;
import fr.iut.adaugustaperangusta.core.overlay.Target;
import fr.iut.adaugustaperangusta.core.overlay.Wall;
import fr.iut.adaugustaperangusta.core.traveller.Block;
import fr.iut.adaugustaperangusta.core.traveller.Character;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;

/**
 * Map where a game takes place. Contains a Cell array.
 *
 * @author jpelloux & Axce
 * @version 1.1.0
 */

public class Map
{
	/**
	 * Default number of blocks. Used when no parameters are given to the
	 * constructor.
	 */
	private static final int DEFAULT_NUMBER_OF_BLOCKS = 1;

	/**
	 * Default height. Used when no parameters are given to the constructor.
	 */
	private static final int DEFAULT_HEIGHT = 10;

	/**
	 * Default width. Used when no parameters are given to the constructor.
	 */
	private static final int DEFAULT_WIDTH = 15;

	/**
	 * Map's height. Also the Cell array height.
	 */
	private final int height;

	/**
	 * Map's width. Also the Cell array width.
	 */
	private final int width;

	/**
	 * Cell array structuring the Map. Structures the Map thanks to the Overlays
	 * and the Travellers attributed to Cells. Takes {@link Map#height} and
	 * {@link Map#width} as dimensions.
	 */
	private final Cell[][] cellArray;

	/**
	 * Block's references list. Used to browse through Blocks.
	 */
	private final Block[] block;

	/**
	 * The number of Block in the map
	 */
	private final int numberOfBlocks;

	/**
	 * The number of Block who are currently define
	 */
	private int actualNumberOfBlocks;

	/**
	 * Map constructor. Generates an array constituted of void Cells taking
	 * <tt>height</tt> and <tt>width</tt> as dimensions. Calls Cell()
	 * constructor without parameters. Thus, created Cells got neither Overlay
	 * nor Traveller.
	 *
	 * @param height
	 *            Map's height.
	 * @param width
	 *            Map's width.
	 * @param numberOfBlocks
	 *            Map's number of Blocks
	 */
	public Map(int height, int width, int numberOfBlocks)
	{
		this.actualNumberOfBlocks = 0;
		this.width = width;
		this.height = height;
		this.cellArray = new Cell[height][width];
		for (int cellHeight = 0; cellHeight < height; cellHeight++)
		{
			for (int cellWidth = 0; cellWidth < width; cellWidth++)
			{
				cellArray[cellHeight][cellWidth] = new Cell();
			}
		}
		this.numberOfBlocks = numberOfBlocks;
		this.block = new Block[this.numberOfBlocks];
		for (int index = 0; index < this.numberOfBlocks; index++)
		{
			this.block[index] = null;
		}
	}

	/**
	 * Maps's contructor without parameters. Generates an array constituted of
	 * void Cells with default dimensions.
	 */
	public Map()
	{
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH, DEFAULT_NUMBER_OF_BLOCKS);
	}

	/**
	 * Maps's contructor for tests. Callable by giving a <tt>char</tt> as
	 * parameter Returns a 4*5 Map, solvable, displaying all Overlays and
	 * Travellers.
	 *
	 * @param devTest
	 *            Any <tt>char</tt>.
	 */
	public Map(char devTest)
	{
		this.width = 4;
		this.height = 7;
		this.numberOfBlocks = 1;
		this.block = new Block[this.numberOfBlocks];
		this.block[1] = new Block(new Position(4, 1), this, 0);
		this.cellArray = new Cell[this.height][this.width];
		this.cellArray[0][0] = new Cell();
		this.cellArray[0][1] = new Cell(new Wall());
		this.cellArray[0][2] = new Cell(new Wall());
		this.cellArray[0][3] = new Cell();
		this.cellArray[1][0] = new Cell(new Wall());
		this.cellArray[1][1] = new Cell(new Floor());
		this.cellArray[1][2] = new Cell(new Floor());
		this.cellArray[1][3] = new Cell(new Wall());
		this.cellArray[2][0] = new Cell(new Wall());
		this.cellArray[2][1] = new Cell(new Floor()); // , new //
														// Character("Findus",
														// // new Position(2,
														// 1)));
		this.cellArray[2][2] = new Cell(new Floor());
		this.cellArray[2][3] = new Cell(new Wall());
		this.cellArray[3][0] = new Cell(new Wall());
		this.cellArray[3][1] = new Cell(new Floor());
		this.cellArray[3][2] = new Cell(new Target());
		this.cellArray[3][3] = new Cell(new Wall());
		this.cellArray[4][0] = new Cell(new Floor());
		this.cellArray[4][1] = new Cell(new Floor(), this.block[0]);
		this.cellArray[4][2] = new Cell(new Floor());
		this.cellArray[4][3] = new Cell(new Floor());
		this.cellArray[5][0] = new Cell(new Floor());
		this.cellArray[5][1] = new Cell(new Floor());
		this.cellArray[5][2] = new Cell(new Floor());
		this.cellArray[5][3] = new Cell(new Floor());
		this.cellArray[6][0] = new Cell();
		this.cellArray[6][1] = new Cell(new Wall());
		this.cellArray[6][2] = new Cell(new Wall());
		this.cellArray[6][3] = new Cell();

	}

	/**
	 * Replaces a Cell into the Map.
	 *
	 * @param iRow
	 *            Row hosting the Cell. Must be lower than {@link Map#height}.
	 * @param iColumn
	 *            Column hosting the Cell. Must be lower than {@link Map#width}.
	 * @param cell
	 *            Cell added to Map.
	 */
	public void setCell(int iRow, int iColumn, Cell cell)
	{
		// TODO throw exception Cell hors de la Map.
		this.cellArray[iRow][iColumn] = cell;
	}

	/**
	 * Height getter.
	 *
	 * @return Map's height.
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Width getter.
	 *
	 * @return Map's width.
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * @param index
	 * @return The Block's reference that is at this.block[index].
	 */
	public Block getBlock(int index) 
	{
		// TODO Exception index invalide
		return this.block[index];
	}

	/**
	 * @param block
	 *            The new block's reference
	 * @param index
	 * @return Modify the Block's reference at this.block[index] .
	 */
	public void setBlock(Block block, int index)
	{
		// TODO Exception index invalide
		this.block[index] = block;
	}

	/**
	 * @param pos
	 * @return Cell's references at given pos.
	 * @throws OutOfMapException
	 */
	public Cell getCell(Position pos) throws OutOfMapException
	{
		if(pos.getX()<0) throw new OutOfMapException(pos.toString());
		if(pos.getX()> this.height-1) throw new OutOfMapException(pos.toString());
		if(pos.getY()<0) throw new OutOfMapException(pos.toString());
		if(pos.getY()>this.width-1) throw new OutOfMapException(pos.toString());
		return this.cellArray[pos.getX()][pos.getY()];
	}

	/**
	 * Return the Traveller's references that is at the given position. Null if
	 * no Traveller at this position.
	 * 
	 * @param pos
	 * @return Traveller's references or Null
	 * @throws OutOfMapException
	 */
	public Traveller getTraveller(Position pos) throws OutOfMapException
	{
		return this.getCell(pos).getTraveller();
	}

	/**
	 * @return The number of block in the map.
	 */
	public int getNumberOfBlocks()
	{
		return this.numberOfBlocks;
	}

	/**
	 * @return The actual number of block in the map.
	 */
	public int getActualNumberOfBlocks()
	{
		return this.actualNumberOfBlocks;
	}

	/**
	 * @param actualNumberOfBlocks
	 *            The new actual number of block.
	 */
	public void setActualNumberOfBlocks(int actualNumberOfBlocks)
	{
		// TODO Exception TooManyBlocks 
		this.actualNumberOfBlocks = actualNumberOfBlocks;
	}

	/**
	 * Try the given cell's accessibility.
	 * 
	 * @param cell
	 *            Cell's reference we want to try
	 * @return True if the cell is accessible.
	 */
	public boolean isAccessible(Cell cell)
	{
		return (cell.getOverlay().isAccessible() && cell.getTraveller() == null);
	}

	/**
	 * Try cell's accessibility of the given cell from the give Position.
	 * 
	 * @param cell
	 *            Reference of the cell we want to try.
	 * @param posOrigine
	 *            Position from where we want to access to the cell.
	 * @return True if the cell is accessible
	 */
	public boolean isAccessible(Cell cell, Position posOrigine)
	{
		return (cell.getOverlay().isAccessible() && isItAPushableBlock(cell, posOrigine));
	}

	/**
	 * Try if a Position is accessible form another Position
	 * 
	 * @param posOrigine
	 *            Traveller's actual Position.
	 * @param posToCheck
	 *            Position where we want the Traveller to move.
	 * @return True if the Traveller can move to posToCheck from posOrigine.
	 * @throws OutOfMapException
	 */
	public boolean isAccessibleFrom(Position posOrigine, Position posToCheck) throws OutOfMapException
	{
		return isAccessible(this.getCell(posToCheck), posOrigine);
	}

	/**
	 * Try if a Traveller is a block and if it can be pushed.
	 * 
	 * @param cell
	 *            Cell's reference of a cell where we want to know if it's a
	 *            pushable Block.
	 * @param posOrigine
	 *            Position from where the block is pushed.
	 * @return True if the Taveller is a pushable block.
	 */
	public boolean isItAPushableBlock(Cell cell, Position posOrigine)
	{

		if (cell.getTraveller() == null)
			return true;
		if (!(cell.getTraveller() instanceof Block))
			return false;
		if (!(cell.getTraveller().isPushableFrom(posOrigine)))
			return false;
		return true;
	}

	/**
	 * Try if a Traveller is a block and if it can be pushed.
	 * 
	 * @param posToCheck
	 *            Cell's Position of a cell where we want to know if it's a
	 *            pushable Block.
	 * @param posOrigine
	 *            Position from where the block is pushed.
	 * @return True if the Taveller is a pushable block.
	 * @throws OutOfMapException
	 */
	public boolean isItAPushableBlock(Position posToCheck, Position posOrigine) throws OutOfMapException
	{
		if (getCell(posToCheck).getTraveller() == null)
			return true;
		if (!(getCell(posToCheck).getTraveller() instanceof Block))
			return false;
		if (!(getCell(posToCheck).getTraveller().isPushableFrom(posOrigine)))
			return false;
		return true;
	}

	/**
	 * toString redefinition. Displays Map on the standard output, surrounding
	 * Cells by "|   |" and '-----'.
	 */
	@Override

	public String toString()
	{
		StringBuilder strMap = new StringBuilder();
		strMap.append("-");
		
		for (int i = 0; i < this.width; i++)
		{
			strMap.append("----");
		}
		strMap.append("\n");
		for (int cellHeight = 0; cellHeight < this.height; cellHeight++)
		{
			for (int cellWidth = 0; cellWidth < this.width; cellWidth++)
			{
				strMap.append("|" + this.cellArray[cellHeight][cellWidth]);
			}
			strMap.append( "|\n-");
			for (int i = 0; i < this.width; i++)
			{
				strMap.append("----");
			}
			strMap.append("\n");
		}
		return strMap.toString();
	}

	/**
	 * Move the Traveller on the Map.
	 * 
	 * @param origine
	 *            Traveller's actual position.
	 * @param end
	 *            Traveller's position after the movement.
	 * @throws OutOfMapException
	 */
	public void moveTrav(Position origine, Position end) throws OutOfMapException
	{
		if (this.isItAPushableBlock(end, origine) && (getCell(end).getTraveller()!=null)&& (getCell(end).getTraveller().isBlock()))
		{
			try
			{
				int localBlockIndex = getCell(end).getTraveller().getTravNumber();
				this.moveTrav(end, end.generatePosFromRelative(end.getRelative(origine)));
				this.getBlock(localBlockIndex).move(end.getRelative(origine));
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getCell(end).setCellTraveller(getCell(origine).getTraveller());
		getCell(origine).setCellTraveller(null);
	}
}
