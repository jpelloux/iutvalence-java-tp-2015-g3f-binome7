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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.traveller.Character;

public class PreviewWindow extends JWindow
{
	public PreviewWindow(Map map)
	{   
	    this.setSize(map.getWidth()*8,map.getHeight()*8);

	    this.setLocation(600,600);

	    JPanel preview = new PreviewMapGUI(map);
	    
	    this.add(preview);
	    this.setVisible(true);
	  
	}

	public static void displayInProgress(){

	}


}
