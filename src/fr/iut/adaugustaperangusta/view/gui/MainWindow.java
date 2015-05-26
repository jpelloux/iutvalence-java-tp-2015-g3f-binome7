package fr.iut.adaugustaperangusta.view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.traveller.Character;

public class MainWindow extends JFrame implements KeyListener
{
	
	private static final int DEFAULT_MENU_BAR_SIZE = 50;

	public MainWindow(Map map)
	{
		
	    this.setTitle("Ad Augusta Per Angusta");
	   
	    //this.setSize(DEFAULT_MAP_SIZE,DEFAULT_MAP_SIZE+DEFAULT_MENU_BAR_SIZE);
	    this.setSize(map.getWidth()*50,map.getHeight()*50+DEFAULT_MENU_BAR_SIZE);
	    
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    this.setJMenuBar(new MenuBar());
	    
	    JPanel mapGui = new MapGUI(map);
	    this.add(mapGui);
	    mapGui.addKeyListener(this);
	    mapGui.requestFocusInWindow();
	    this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
System.out.println("aaz");		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
