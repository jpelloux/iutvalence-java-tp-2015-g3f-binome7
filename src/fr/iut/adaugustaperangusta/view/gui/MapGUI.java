package fr.iut.adaugustaperangusta.view.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapGUI extends JPanel
{
	public MapGUI()
	{
		this.setLayout(new GridLayout(5,5));
		for (int i=0 ; i<25 ; i++)
		{
			this.add(new JButton(Integer.toString(i)));
		//JLabel image = new JLabel( new ImageIcon( "no.jpg"));
//			this.setLayout(new BorderLayout());
			//this.add(image);
		}
	}
}
