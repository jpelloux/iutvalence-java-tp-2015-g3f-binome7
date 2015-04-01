/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;


/* TODO JAVADOC. */
public class Map
{
	/* TODO JAVADOC. */
	private static final int	DEFAULT_HEIGHT	= 10;
	/* TODO JAVADOC. */
	private static final int	DEFAULT_WIDTH	= 15;
	
	/* TODO JAVADOC. */
	private final int			height;

	/* TODO JAVADOC. */
	private final int			width;

	/* TODO JAVADOC. */
	private final Cell[][]		tabCell;
	
	/* TODO JAVADOC. */
	public Map(int height, int width)
	{
		this.width = width;
		this.height = height;
		this.tabCell = new Cell[height][width];
		for (int cellHeight = 0; cellHeight < height; cellHeight++)
		{
			for (int cellWidth = 0; cellWidth < width; cellWidth++)
			{
				tabCell[cellHeight][cellWidth] = new Cell();
			}
		}
	}
	
	/* TODO JAVADOC. */
	public Map()
	{
		this(DEFAULT_HEIGHT,DEFAULT_WIDTH);
	}
	
	/*
	 * Le paramètre permet de générer une map de test en appelant ce
	 * constructeur.
	 */
	/* TODO JAVADOC. */
	public Map(char devTest)
	{
		Character lol = new Character("Okay");
		this.width = 4;
		this.height = 5;
		this.tabCell = new Cell[height][width];
		this.tabCell[0][0] = new Cell();
		this.tabCell[0][1] = new Cell(new Wall());
		this.tabCell[0][2] = new Cell(new Wall());
		this.tabCell[0][3] = new Cell();
		this.tabCell[1][0] = new Cell(new Wall());
		this.tabCell[1][1] = new Cell(new Floor());
		this.tabCell[1][2] = new Cell(new Floor());
		this.tabCell[1][3] = new Cell(new Wall());
		this.tabCell[2][0] = new Cell(new Wall());
		this.tabCell[2][1] = new Cell(new Floor(), new Character("Findus"));
		this.tabCell[2][2] = new Cell(new Floor(), new Block());
		this.tabCell[2][3] = new Cell(new Wall());
		this.tabCell[3][0] = new Cell(new Wall());
		this.tabCell[3][1] = new Cell(new Floor());
		this.tabCell[3][2] = new Cell(new Target());
		this.tabCell[3][3] = new Cell(new Wall());
		this.tabCell[4][0] = new Cell();
		this.tabCell[4][1] = new Cell(new Wall());
		this.tabCell[4][2] = new Cell(new Wall());
		this.tabCell[4][3] = new Cell();
	}
	
	public void setTabCell(int indiceLigne, int indiceColonne, Cell cell)
	{
		this.tabCell[indiceLigne][indiceColonne] = cell;
	}
	
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public String toString()
	{
		/*
		 * TODO Discuter en séance (ou à regarder par vous même) : String vs
		 * StringBuffer vs StringBuilder.
		 */
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
				str = str + "|" + this.tabCell[cellHeight][cellWidth];
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
}
