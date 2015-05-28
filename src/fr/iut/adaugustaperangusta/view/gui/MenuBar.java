package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	public MenuBar(GuiIO guiIO) {
		this.add(new MenuFile("Fichier", guiIO));
	}

}
