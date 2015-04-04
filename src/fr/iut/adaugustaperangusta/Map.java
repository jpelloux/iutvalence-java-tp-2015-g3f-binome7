package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;
import fr.iut.adaugustaperangusta.traveller.Character;

/**
 * Map où se déroule une partie.
 * Elle contient un tableau de Cells.
 */
public class Map
{
	/**
	 * Hauteur par défaut.
	 * Utilisée par le contructeur sans paramètres.
	 */
	private static final int	DEFAULT_HEIGHT	= 10;

	/**
	 * Largeur par défaut.
	 * Utilisée par le contructeur sans paramètres.
	 */
	private static final int	DEFAULT_WIDTH	= 15;
	
	/**
	 * Hauteur de la Map.
	 */
	private final int			height;

	/**
	 * Largeur de la Map.
	 */
	private final int			width;

	/**
	 * Tableau de Cells structurant la Map.
	 * Grâce aux Overlays et aux Travellers sur les Cells, il structure la Map.
	 * Il prend {@link Map#height} et {@link Map#width} pour dimensions.
	 */
	private final Cell[][]		tabCell;
	
	/**
	 * Constructeur Map.
	 * Il génère un tableau de Cells vides ayant pour dimensions height et width.
	 * Il appelle le contructeur vide Cell(). Ainsi, les Cells créées n'ont ni Overlay ni Traveller.
	 * 
	 * @param height	Hauteur de la Map.
	 * @param width		Largeur de la Map.
	 */
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
	
	/**
	 * Constructeur Map sans paramètres.
	 * Il génère un tableau de Cells vides ayant les dimensions par défaut.
	 */
	public Map()
	{
		this(DEFAULT_HEIGHT,DEFAULT_WIDTH);
	}
	
	/**
	 * Contructeur Map de test.
	 * On peut appeler ce contructeur en passant un char en paramètre.
	 * Il renvoie une Map de 4*5, sovable, présentant tous les Overlays et Travellers.
	 * 
	 * @param devTest	N'importe quel caractère.
	 */
	public Map(char devTest)
	{
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
	
	/**
	 * Remplace une Cell de la Map.
	 * 
	 * @param indiceLigne	Ligne acceuillant la Cell. Doit être inférieur à {@link Map#height}.
	 * @param indiceColonne	Colonne accueillant la Cell. Doit être inférieur à {@link Map#width}.
	 * @param cell			Cell ajoutée à la Map.
	 */
	public void setCell(int indiceLigne, int indiceColonne, Cell cell)
	{
		// TODO throw exception Cell hors de la Map.
		this.tabCell[indiceLigne][indiceColonne] = cell;
	}
	
	/**
	 * Getter height.
	 * 
	 * @return La hauteur de la Map.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Getter width.
	 * 
	 * @return La largeur de la Map.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Méthode d'affichage.
	 * Affiche la Map sur la sortie standard en encadrant les Cell par des "|   |" et des '-----'.
	 */
	@Override
	public String toString()
	{
		// TODO utiliser un StringBuffer/StringBuilder.
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
