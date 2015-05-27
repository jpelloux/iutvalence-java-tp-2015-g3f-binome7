package fr.iut.adaugustaperangusta.view.gui;


import java.io.File;
import java.io.IOException;
 

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
 
 
public class SelectFile {
    public static final File fileSelection(){
        File localRep = null;
        try {
        	localRep = new File(".").getCanonicalFile();
        } catch(IOException e) {}

        JOptionPane alert = new JOptionPane();
        
		alert.showMessageDialog(null ,"Must be a valide .txt Map.", "ReadMe", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser dialogue = new JFileChooser(localRep);
        dialogue.showOpenDialog(alert);
        
    	return dialogue.getSelectedFile();
    }
}