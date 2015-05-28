package fr.iut.adaugustaperangusta.view.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class HomeWindow extends JWindow {

	private PreviewWindow preview;

	public HomeWindow(GuiIO guiIO) {
		this.setLocationRelativeTo(null);
		this.requestFocusInWindow();
		this.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel imageVictory = new JLabel(new ImageIcon("img/aapa.png"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 300;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(imageVictory, c);

		JButton exit = new JButton("Exit");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 150;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(exit, c);

		JButton loadMap = new JButton("LoadMap");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 150;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(loadMap, c);

		JButton play = new JButton("Play");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 300;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(play, c);

		this.preview = new PreviewWindow(guiIO.getMap(),
				this.getLocationOnScreen());
		HomeActionListener myAL = new HomeActionListener(play, loadMap, exit,
				this.preview, guiIO);
		play.addActionListener(myAL);
		loadMap.addActionListener(myAL);
		exit.addActionListener(myAL);

		this.add(panel);
		this.pack();
	}
}
