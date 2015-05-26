package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuFichier extends JMenu
{

	public MenuFichier(String name)
	{
	    super(name);
	    JMenuItem FichierImport = new JMenu("Import Map");
	    this.add(FichierImport);
		JMenuItem FichierReset= new JMenuItem("Reset");
	    this.add(FichierReset);
	    JMenuItem FichierExit = new JMenuItem("Exit");
	    this.add(FichierExit);
	}
}
