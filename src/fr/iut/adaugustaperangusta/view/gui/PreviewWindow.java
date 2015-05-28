package fr.iut.adaugustaperangusta.view.gui;

import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JWindow;

import fr.iut.adaugustaperangusta.core.Map;

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
