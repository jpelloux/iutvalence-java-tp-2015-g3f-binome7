package fr.iut.adaugustaperangusta.view.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.iut.adaugustaperangusta.core.RelativePos;

public class MyKeyListener implements KeyListener{

	private GuiIO guiIO;
	
	public MyKeyListener(GuiIO guiIO){
		this.guiIO = guiIO;
	}
	
    public void keyTyped(KeyEvent e) {
       
    }

    public void keyPressed(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyChar())
		{
		case 'z':
			guiIO.move(RelativePos.NORTH);
			break;
		case 'q':
			guiIO.move(RelativePos.WEST);
			break;
		case 's':
			guiIO.move(RelativePos.SOUTH);
			break;

		case 'd':
			guiIO.move(RelativePos.EAST);
			break;
		default:
		}	
    	guiIO.displayMap();
    }
}