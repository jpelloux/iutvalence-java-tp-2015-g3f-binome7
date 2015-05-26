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

public class MapGUI extends JPanel
{
	/**
	 * 
	 */
	public MapGUI()
	{
		this.setLayout(new GridLayout(5,5));

		for (int i=0 ; i<25 ; i++)
		{
			//this.add(new JButton(Integer.toString(i)));
			
			JLabel image = new JLabel( new ImageIcon( "cell.png"));
			this.add(image);

		}
	}
	  //public void paintComponent(Graphics g){
		 // for (int i=0 ; i<25 ; i++)
		 // {
			//  try {
			//	  Image img = ImageIO.read(new File("cell.png"));
			//	  g.drawImage(img, i%5*50, i/5*50, this);
		      //Pour une image de fond
		      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			//  } catch (IOException e) {
		    //  e.printStackTrace();
		  //  }                
		 // }  
	//  }
}
