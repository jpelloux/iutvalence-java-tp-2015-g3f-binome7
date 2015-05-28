package fr.iut.adaugustaperangusta.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeActionListener implements ActionListener {
	private JButton play;
	private JButton loadMap;
	private GuiIO guiIO;
	private JButton exit;
	private PreviewWindow preview;

	public HomeActionListener(JButton play, JButton loadMap, JButton exit,
			PreviewWindow preview, GuiIO guiIO) {
		this.play = play;
		this.loadMap = loadMap;
		this.guiIO = guiIO;
		this.exit = exit;
		this.preview = preview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == play) {
			guiIO.lunchGame();
			this.preview.dispose();

		} else if (source == loadMap) {
			guiIO.selectFile();
		} else if (source == exit) {

			this.preview.dispose();
			guiIO.closeGame();
		}
	}
}
