package fr.iut.adaugustaperangusta.view.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MapGUI extends JPanel
{
	public MapGUI()
	{
		this.setLayout(new GridLayout(5,5));
		for (int i=0 ; i<25 ; i++)
		{
			this.add(new JButton(Integer.toString(i)));
		}
	}
}
