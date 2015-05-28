package fr.iut.adaugustaperangusta.view.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.Position;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;

public class MapGUI extends JPanel {

	private static final int DEFAULT_MAP_SIZE = 50;
	private Image floor;
	private Image wall;
	private Image target;
	private Image block;
	private Image player;

	private Map map;

	public MapGUI(Map map) {
		try {
			this.wall = ImageIO.read(new File("img/wall.png"));
			this.floor = ImageIO.read(new File("img/floor.png"));
			this.target = ImageIO.read(new File("img/target2.png"));
			this.block = ImageIO.read(new File("img/block.png"));
			this.player = ImageIO.read(new File("img/player.png"));

		} catch (IOException e) {
			e.printStackTrace();

		}

		this.map = map;

	}

	public void paintComponent(Graphics g) {
		for (int width = 0; width < map.getWidth(); width++) {
			for (int height = 0; height < map.getHeight(); height++) {
				try {
					if (map.getCell(new Position(height, width)).getOverlay()
							.toString() == "!") {
						g.drawImage(floor, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
						g.drawImage(target, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
					}
				} catch (OutOfMapException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (map.getCell(new Position(height, width)).getOverlay()
							.toString() == "W") {
						g.drawImage(wall, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
					}
				} catch (OutOfMapException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (map.getCell(new Position(height, width)).getOverlay()
							.toString() == " ") {
						g.drawImage(floor, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
					}
					if (map.getCell(new Position(height, width)).getTraveller() != null
							&& map.getCell(new Position(height, width))
									.getTraveller().isBlock()) {
						g.drawImage(block, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
					}
					if (map.getCell(new Position(height, width)).getTraveller() != null
							&& !map.getCell(new Position(height, width))
									.getTraveller().isBlock()) {
						g.drawImage(player, width * DEFAULT_MAP_SIZE, height
								* DEFAULT_MAP_SIZE, this);
					}
				} catch (OutOfMapException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}
}
