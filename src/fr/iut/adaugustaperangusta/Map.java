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
 * Map où se déroule une partie.
 * Elle contient un tableau de Cells.
 *
 * @author TODO
 * @version TODO
 */
public class Map {
    /* TODO Translate. */
    /**
     * Hauteur par défaut.
     * Utilisée par le contructeur sans paramètres.
     */
    private static final int DEFAULT_HEIGHT = 10;
    /* TODO Translate. */
    /**
     * Largeur par défaut.
     * Utilisée par le contructeur sans paramètres.
     */
    private static final int DEFAULT_WIDTH  = 15;
    /* TODO Translate. */
    /**
     * Hauteur de la Map.
     */
    private final int      height;
    /* TODO Translate. */
    /**
     * Largeur de la Map.
     */
    private final int      width;
    /* TODO Translate. */
    /**
     * Tableau de Cells structurant la Map.
     * Grâce aux Overlays et aux Travellers sur les Cells, il structure la Map.
     * Il prend {@link Map#height} et {@link Map#width} pour dimensions.
     */
    private final Cell[][] tabCell;
    
	private Block block;

    /* TODO Translate. */
    /**
     * Constructeur Map.
     * Il génère un tableau de Cells vides ayant pour dimensions height et width.
     * Il appelle le contructeur vide Cell(). Ainsi, les Cells créées n'ont ni Overlay ni Traveller.
     *
     * @param height Hauteur de la Map.
     * @param width  Largeur de la Map.
     */
    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        this.tabCell = new Cell[height][width];
        for (int cellHeight = 0; cellHeight < height; cellHeight++) {
            for (int cellWidth = 0; cellWidth < width; cellWidth++) {
                tabCell[cellHeight][cellWidth] = new Cell();
            }
        }
        this.block =null;
    }

    /* TODO Translate. */
    /**
     * Constructeur Map sans paramètres.
     * Il génère un tableau de Cells vides ayant les dimensions par défaut.
     */
    public Map() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    /* TODO Translate. */
    /**
     * Contructeur Map de test.
     * On peut appeler ce contructeur en passant un char en paramètre.
     * Il renvoie une Map de 4*5, sovable, présentant tous les Overlays et Travellers.
     *
     * @param devTest N'importe quel caractère.
     */
    public Map(char devTest) {
        this.width = 4;
        this.height = 7;
        this.block=new Block(new Position(4,1),this);
        this.tabCell = new Cell[this.height][this.width];
        this.tabCell[0][0] = new Cell();
        this.tabCell[0][1] = new Cell(new Wall());
        this.tabCell[0][2] = new Cell(new Wall());
        this.tabCell[0][3] = new Cell();
        this.tabCell[1][0] = new Cell(new Wall());
        this.tabCell[1][1] = new Cell(new Floor());
        this.tabCell[1][2] = new Cell(new Floor());
        this.tabCell[1][3] = new Cell(new Wall());
        this.tabCell[2][0] = new Cell(new Wall());
        this.tabCell[2][1] = new Cell(new Floor());//, new Character("Findus", new Position(2, 1)));
        this.tabCell[2][2] = new Cell(new Floor());
        this.tabCell[2][3] = new Cell(new Wall());
        this.tabCell[3][0] = new Cell(new Wall());
        this.tabCell[3][1] = new Cell(new Floor());
        this.tabCell[3][2] = new Cell(new Target());
        this.tabCell[3][3] = new Cell(new Wall());
        this.tabCell[4][0] = new Cell(new Floor());
        this.tabCell[4][1] = new Cell(new Floor(), this.block);
        this.tabCell[4][2] = new Cell(new Floor());
        this.tabCell[4][3] = new Cell(new Floor());
        this.tabCell[5][0] = new Cell(new Floor());
        this.tabCell[5][1] = new Cell(new Floor());
        this.tabCell[5][2] = new Cell(new Floor());
        this.tabCell[5][3] = new Cell(new Floor());
        this.tabCell[6][0] = new Cell();
        this.tabCell[6][1] = new Cell(new Wall());
        this.tabCell[6][2] = new Cell(new Wall());
        this.tabCell[6][3] = new Cell();
       
        
    }

    /* TODO Translate. */
    /**
     * Remplace une Cell de la Map.
     *
     * @param indiceLigne   Ligne acceuillant la Cell. Doit être inférieur à {@link Map#height}.
     * @param indiceColonne Colonne accueillant la Cell. Doit être inférieur à {@link Map#width}.
     * @param cell          Cell ajoutée à la Map.
     */
    public void setCell(int indiceLigne, int indiceColonne, Cell cell) {
        // TODO throw exception Cell hors de la Map.
        this.tabCell[indiceLigne][indiceColonne] = cell;
    }

    /* TODO Translate. */
    /**
     * Getter height.
     *
     * @return La hauteur de la Map.
     */
    public int getHeight() {
        return height;
    }

    /* TODO Translate. */
    /**
     * Getter width.
     *
     * @return La largeur de la Map.
     */
    public int getWidth() {
        return width;
    }

	/* TODO JAVADOC. */
    public Block getBlock()
	{
		return block;
	}
    
	/* TODO JAVADOC. */
	public void setBlock(Block block)
	{
		this.block = block;
	}

	/* TODO JAVADOC. */
    public Cell getCell(Position pos) {
        return this.tabCell[pos.getX()][pos.getY()];
    }

    /* TODO JAVADOC. */
    public Traveller getTraveller(Position pos) {
        return this.getCell(pos).getTraveller();
    }

    /* TODO JAVADOC. */
    public boolean isAccessible(Cell cell) {
        //boolean access;
        //access = (cell.getOverlay().isAccessible() && cell.getTraveller() == null);
        return (cell.getOverlay().isAccessible() && cell.getTraveller()==null);
    }
   
    public boolean isAccessible(Cell cell, Position posOrigine) {
    	return (cell.getOverlay().isAccessible() && isItAPushableBlock(cell, posOrigine));
    }

    public boolean isAccessibleFrom(Position posOrigine,Position posToCheck)
    {
    	return isAccessible(this.getCell(posToCheck), posOrigine);
    }
    
    public boolean isItAPushableBlock(Cell cell,Position posOrigine)
    {

//   	System.out.println("We reach isItAPushableBlock");
    	if(cell.getTraveller()==null) return true;
//    	System.out.println("Le traveller est non null");
//    	System.out.println(cell.getTraveller());
    	if(!(cell.getTraveller() instanceof Block)) return false;
//    	System.out.println("C'est bien un block");
    	if(!(cell.getTraveller().isPushableFrom(posOrigine))) return false;
//    	System.out.println("Il est bien pushable");
    	return true;
    }
    
    public boolean isItAPushableBlock(Position posToCheck,Position posOrigine)
    {
//    	System.out.println("isItAPushableBLock(Pos,Pos)");
    	if(getCell(posToCheck).getTraveller()==null) return true;
//    	System.out.println("Le traveller est non null");
//    	System.out.println(posToCheck);
//    	System.out.println(posOrigine);
//    	System.out.println(getCell(posOrigine));
//    	System.out.println(getCell(posToCheck));
    	if(!(getCell(posToCheck).getTraveller() instanceof Block)) return false;
//    	System.out.println("C'est bien un block");
    	if(!(getCell(posToCheck).getTraveller().isPushableFrom(posOrigine))) return false;
//    	System.out.println("Il est bien pushable");
    	return true;
    }
    /* TODO Translate. */
    /**
     * Méthode d'affichage.
     * Affiche la Map sur la sortie standard en encadrant les Cell par des "|   |" et des '-----'.
     */
    @Override
    public String toString() {
        // TODO utiliser un StringBuilder.
        String str = new String();
        str += "-";
        for (int i = 0; i < this.width; i++) {
            str += "----";
        }
        str += "\n";
        for (int cellHeight = 0; cellHeight < this.height; cellHeight++) {
            for (int cellWidth = 0; cellWidth < this.width; cellWidth++) {
                str = str + "|" + this.tabCell[cellHeight][cellWidth];
            }
            str += "|\n-";
            for (int i = 0; i < this.width; i++) {
                str += "----";
            }
            str += "\n";
        }
        return str;
    }

	public void moveTrav(Position origine, Position end)
	{ //TODO Gestion cas cible 
//		System.out.println("----------------");
//		System.out.println("Reach moveTrav");
//		System.out.println(origine);
//		System.out.println(end);
//		
//		System.out.println(this.isItAPushableBlock(end,origine)+" 124");

	if(this.isItAPushableBlock(end,origine)&& (getCell(end).getTraveller() instanceof Block))
		{
		try
		{
//			System.out.println("----------------");
//			System.out.println(origine.getRelative(end)); 
//			System.out.println("----------------");
			
			this.moveTrav(end, end.generatePosFromRelative(end.getRelative(origine)));
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
