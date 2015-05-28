package fr.iut.adaugustaperangusta.view.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
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

public class PreviewWindow extends JWindow {
	private static final int DEFAULT_LITTLE_IMG_SIZE = 8;

	public PreviewWindow(Map map, Point location) {
		this.setSize(map.getWidth() * DEFAULT_LITTLE_IMG_SIZE, map.getHeight()
				* DEFAULT_LITTLE_IMG_SIZE);

		location.move((int) location.getX()
				- (map.getWidth() * DEFAULT_LITTLE_IMG_SIZE),
				(int) location.getY());

		this.setLocation(location);

		JPanel preview = new PreviewMapGUI(map);

		this.add(preview);
		this.setVisible(true);

	}
}
