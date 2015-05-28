package fr.iut.adaugustaperangusta.view.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class VictoryWindow extends JWindow {

	public VictoryWindow(MainWindow mainWindow, GuiIO guiIO) {
		this.setLocationRelativeTo(mainWindow);
		this.requestFocusInWindow();
		this.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel imageVictory = new JLabel(new ImageIcon("img/victory.png"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 300;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(imageVictory, c);

		JButton quit = new JButton("Quitter");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 150;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(quit, c);

		JButton home = new JButton("Home");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 150;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(home, c);

		JButton replay = new JButton("Rejouer");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.weightx = 300;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(replay, c);

		VictoryActionListener myAL = new VictoryActionListener(quit, replay,
				home, guiIO);
		quit.addActionListener(myAL);
		replay.addActionListener(myAL);
		home.addActionListener(myAL);

		this.add(panel);
		this.pack();
	}
}
