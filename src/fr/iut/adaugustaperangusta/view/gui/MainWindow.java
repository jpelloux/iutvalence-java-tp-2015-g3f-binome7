package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.iut.adaugustaperangusta.core.Map;

public class MainWindow extends JFrame {

	private static final int DEFAULT_MENU_BAR_SIZE = 50;
	private static final int DEFAULT_IMG_SIZE = 50;

	public MainWindow(Map map, MyKeyListener keyListener, GuiIO guiIO) {

		this.setTitle("Ad Augusta Per Angusta");

		this.setSize(map.getWidth() * DEFAULT_IMG_SIZE, map.getHeight()
				* DEFAULT_IMG_SIZE + DEFAULT_MENU_BAR_SIZE);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setJMenuBar(new MenuBar(guiIO));

		JPanel mapGui = new MapGUI(map);
		this.add(mapGui);
		this.addKeyListener(keyListener);
		this.requestFocusInWindow();
		this.setVisible(true);
	}

}
