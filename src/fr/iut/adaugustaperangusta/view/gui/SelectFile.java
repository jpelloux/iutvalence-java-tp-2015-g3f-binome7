package fr.iut.adaugustaperangusta.view.gui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectFile {
	public static final File fileSelection() {
		File localRep = null;
		try {
			localRep = new File(".").getCanonicalFile();
		} catch (IOException e) {
		}
		
		JOptionPane alert = new JOptionPane();

		JOptionPane.showMessageDialog(null, "Must be a valid .txt Map.", "ReadMe",
				JOptionPane.INFORMATION_MESSAGE);
		JFileChooser dialogue = new JFileChooser(localRep);

			
		dialogue.showOpenDialog(alert);
		dialogue.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
		return dialogue.getSelectedFile();
	}
}