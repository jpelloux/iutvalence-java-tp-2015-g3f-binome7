package fr.iut.adaugustaperangusta.view.gui;


import java.io.File;
import java.io.IOException;
 
import javax.swing.JFileChooser;
 
 
public class SelectFile {
    public static final File fileSelection(){
        File localRep = null;
        try {
        	localRep = new File(".").getCanonicalFile();
            System.out.println("Répertoire courant : " + localRep);
        } catch(IOException e) {}

        JFileChooser dialogue = new JFileChooser(localRep);
         
        dialogue.showOpenDialog(null);
        System.out.println("Fichier choisi : " + dialogue.getSelectedFile());
    	return dialogue.getSelectedFile();
    }
}