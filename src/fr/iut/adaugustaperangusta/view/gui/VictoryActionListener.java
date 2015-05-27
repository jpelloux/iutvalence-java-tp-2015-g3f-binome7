package fr.iut.adaugustaperangusta.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VictoryActionListener implements ActionListener
{
	private JButton quit;
	private JButton replay;
	private GuiIO guiIO;

	
	public VictoryActionListener(JButton quit, JButton replay,GuiIO guiIO)
	{
		this.quit = quit;
		this.replay = replay;
		this.guiIO = guiIO;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		 
		if(source == quit){
			guiIO.closeGame();
			System.exit(0);

		} else if(source == replay){
			guiIO.replay();
		}
	}
}
