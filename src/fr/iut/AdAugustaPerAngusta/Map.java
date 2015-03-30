package fr.iut.AdAugustaPerAngusta;

import fr.iut.AdAugustaPerAngusta.overlay.*;
import fr.iut.AdAugustaPerAngusta.overlay.Character;

public class Map {
	
	private static final int DEFAULT_HEIGHT = 15;
	private static final int DEFAULT_WIDTH = 10;
	
	private int height;
	private int width;
	private Cell[][] tabCell;
	
	
	public Map(int height, int width)
	{
		this.width= width;
		this.height= height;
		this.tabCell= new Cell[height][width];
		for(int cellHeight= 0 ; cellHeight < height ; cellHeight++)
		{
			for(int cellWidth= 0 ; cellWidth < width ; cellWidth++)
			{
				tabCell[cellHeight][cellWidth]= new Cell();
			}
		}
	}
	
	public Map()
	{
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Map(char devTest)
	{
		this.width= 4;
		this.height= 2;
		this.tabCell= new Cell[height][width];
		this.tabCell[0][0]= new Cell();
		this.tabCell[0][1]= new Cell(new Wall());
		this.tabCell[0][2]= new Cell(new Character());
		this.tabCell[0][3]= new Cell(new Target());
		this.tabCell[1][0]= new Cell(new Empty());
		this.tabCell[1][1]= new Cell(new Empty());
		this.tabCell[1][2]= new Cell(new Block());
		this.tabCell[1][3]= new Cell(new Target());
	}
	
	@Override
	public String toString()
	{
		String str= new String();
		str+= "-";
		for(int i= 0 ; i < this.width ; i++) str+= "----";
		str+= "\n";
		
		int cellHeight;
		int cellWidth;
		for(cellHeight= 0 ; cellHeight < this.height ; cellHeight++)
		{
			for(cellWidth= 0 ; cellWidth < this.width ; cellWidth++)
			{
				str= str + "|" + this.tabCell[cellHeight][cellWidth].toString();
			}
			str+= "|\n-";
			for(int i= 0 ; i < this.width ; i++) str+= "----";
			str+= "\n";
		}
		
		return str;
	}
}
