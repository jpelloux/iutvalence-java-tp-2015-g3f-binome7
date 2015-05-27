package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar
{
	
	
	public MenuBar(GuiIO guiIO)
	{
		
	    this.add(new MenuFile("Fichier",guiIO));
	    

	}

}
