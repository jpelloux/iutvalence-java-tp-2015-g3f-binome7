package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.exceptions.SamePosException;
import fr.iut.adaugustaperangusta.exceptions.TooFarException;
import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;
import fr.iut.adaugustaperangusta.traveller.Traveller;

/* TODO Translate. */

/**
 * Map where a game takes place. Contains a Cell array.
 *
 * @author jpelloux & Axce
 * @version 1.0.0
 */
public class Map
{
	/**
	 * Default number of blocks. Used when no parameters are given to the constructor.
	 */
	private static final int	DEFAULT_NUMBER_OF_BLOCKS	= 1;

	/**
	 * Default height. Used when no parameters are given to the constructor.
	 */
	private static final int	DEFAULT_HEIGHT	= 10;
	
	/**
	 * Default width. Used when no parameters are given to the constructor.
	 */
	private static final int	DEFAULT_WIDTH	= 15;
	
	/**
	 * Map's height. Also the Cell array height.
	 */
	private final int			height;
	
	/**
	 * Map's width. Also the Cell array width.
	 */
	private final int			width;
	
	/**
	 * Cell array structuring the Map. Structures the Map thanks to the Overlays
	 * and the Travellers attributed to Cells. Takes {@link Map#height} and
	 * {@link Map#width} as dimensions.
	 */
	private final Cell[][]		cellArray;
	
	/* TODO Translate */
	/**
	 *  Reference directe vers le block que contient la map
	 */
	private final Block[]				block;
	private final int numberOfBlocks;
	
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
	 * 			  Map's number of Blocks           
	 */
	public Map(int height, int width,int numberOfBlocks)
	{
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
		for(int index =0; index < this.numberOfBlocks; index++)
		{
			this.block[index]=null;
		}
	}
	
	/**
	 * Maps's contructor without parameters. Generates an array constituted of
	 * void Cells with default dimensions.
	 */
	public Map()
	{
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH,DEFAULT_NUMBER_OF_BLOCKS);
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
		this.block[1] = new Block(new Position(4, 1), this);
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
		this.cellArray[2][1] = new Cell(new Floor()); //, new // Character("Findus", // new Position(2, 1)));
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
	
	/* TODO Translate */
	/**
	 * @param index
	 * @return Le bloc courrant de la map place a l'index 
	 */
	public Block getBlock(int index)
	{
		// TODO Exception index invalide
		return this.block[index];
	}
	
	/* TODO Translate */
	/**
	 * @return Change le bloc  
	 */
	public void setBlock(Block block,int index)
	{
		this.block[index] = block;
	}
	
	/* TODO Translate */
	/**
	 * Retourne la ref de la cellule présente a la pos en param
	 * @param pos
	 * @return
	 */
	public Cell getCell(Position pos)
	{
		//Exceptions ???
		return this.cellArray[pos.getX()][pos.getY()];
	}
	
	/* TODO Translate */
	/**
	 * Retourne la ref du traveller present a la pos en param. Null si pas de traveller
	 * @param pos
	 * @return
	 */
	public Traveller getTraveller(Position pos)
	{
		//Exceptions ???
		return this.getCell(pos).getTraveller();
	}
	
	/*TODO Javadoc */
	public int getNumberOfBlocks()
	{
		return this.numberOfBlocks;
	}

	
	/* TODO Translate */
	/**
	 * Teste l'accessibilite de la cell dont la ref est en param
	 * @param cell
	 * @return
	 */
	public boolean isAccessible(Cell cell)
	{
		return (cell.getOverlay().isAccessible() && cell.getTraveller() == null);
	}
	
	/* TODO Translate */
	/**
	 * Teste l'accecibilete de la cell dont la ref est donne en param depuis la position donne en param
	 * @param cell
	 * @param posOrigine
	 * @return
	 */
	public boolean isAccessible(Cell cell, Position posOrigine)
	{
		return (cell.getOverlay().isAccessible() && isItAPushableBlock(cell,
				posOrigine));
	}
	
	/* TODO Translate */
	/**
	 * Verifie si une position est accessible depuis une autre position
	 * @param posOrigine
	 * @param posToCheck
	 * @return
	 */
	public boolean isAccessibleFrom(Position posOrigine, Position posToCheck)
	{
		return isAccessible(this.getCell(posToCheck), posOrigine);
	}
	
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
	
	public boolean isItAPushableBlock(Position posToCheck, Position posOrigine)
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
	 * toString redefinition.
	 * Displays Map on the standard output, surrounding Cells by "|   |" and '-----'.
	 */
	@Override
	public String toString()
	{
		// TODO utiliser un StringBuilder.
		String str = new String();
		str += "-";
		for (int i = 0; i < this.width; i++)
		{
			str += "----";
		}
		str += "\n";
		for (int cellHeight = 0; cellHeight < this.height; cellHeight++)
		{
			for (int cellWidth = 0; cellWidth < this.width; cellWidth++)
			{
				str = str + "|" + this.cellArray[cellHeight][cellWidth];
			}
			str += "|\n-";
			for (int i = 0; i < this.width; i++)
			{
				str += "----";
			}
			str += "\n";
		}
		return str;
	}
	
	public void moveTrav(Position origine, Position end)
	{
		if (this.isItAPushableBlock(end, origine)
				&& (getCell(end).getTraveller() instanceof Block))
		{
			try
			{
				// TODO List of block donc faut changer --> ajouter un blocNumber dans Block
				this.moveTrav(end,
						end.generatePosFromRelative(end.getRelative(origine)));
				this.getBlock().move(end.getRelative(origine));
			} catch (TooFarException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SamePosException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getCell(end).setCellTraveller(getCell(origine).getTraveller());
		getCell(origine).setCellTraveller(null);
	}
}
