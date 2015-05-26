package fr.iut.adaugustaperangusta.view.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{
	
	private static final int DEFAULT_MENU_BAR_SIZE = 40;
	private static final int DEFAULT_MAP_SIZE = 250;

	public MainWindow()
	{
	    this.setTitle("Ad Augusta Per Angusta");
	   
	    this.setSize(DEFAULT_MAP_SIZE,DEFAULT_MAP_SIZE+DEFAULT_MENU_BAR_SIZE);
	    this.setResizable(true);
	    this.setLocationRelativeTo(null);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setJMenuBar(new MenuBar());
	    
	    this.add(new MapGUI());

	    this.setVisible(true);
	}
}
