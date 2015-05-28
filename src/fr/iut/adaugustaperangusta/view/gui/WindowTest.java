package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JFrame;

import fr.iut.adaugustaperangusta.utils.CreateMap;

/**
 * @deprecated
 */
public class WindowTest {
	public static void main(String[] args)
	{
		MainWindow fen = new MainWindow(CreateMap.importFromFile("Test.txt"), new MyKeyListener(new )); 
	}
}
