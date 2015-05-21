package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuFichier extends JMenu
{
	
	
	
	public MenuFichier(String name)
	{
	    super(name);
		JMenuItem FichierReset= new JMenu("Reset");
	    this.add(FichierReset);
	}
}
