package fr.iut.AdAugustaPerAngusta;

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
