package fr.iut.adaugustaperangusta.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuFile extends JMenu implements ActionListener {
	private JMenuItem fileImport;
	private JMenuItem fileReset;
	private JMenuItem fileExit;
	private JMenuItem fileHome;
	private JMenuItem aboutUS;
	private GuiIO guiIO;

	public MenuFile(String name, GuiIO guiIO) {
		super(name);
		this.fileImport = new JMenuItem("Import Map");
		this.add(this.fileImport);
		this.fileReset = new JMenuItem("Reset");
		this.add(this.fileReset);
		this.fileHome = new JMenuItem("Home");
		this.add(this.fileHome);
		this.aboutUS = new JMenuItem("About Us");
		this.add(this.aboutUS);
		this.fileExit = new JMenuItem("Exit");
		this.add(this.fileExit);

		this.guiIO = guiIO;

		this.fileImport.addActionListener(this);
		this.fileReset.addActionListener(this);
		this.fileExit.addActionListener(this);
		this.fileHome.addActionListener(this);
		this.aboutUS.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == fileImport) {
			guiIO.closeWindow();
			guiIO.selectFile();
		} else if (source == aboutUS) {
			JOptionPane information1 = new JOptionPane();
			ImageIcon soonTM = new ImageIcon("soonTM.png");
			information1
					.showMessageDialog(
							null,
							"This will be available soon(tm) blizzard so...\n Maybe someday...\n For real...\n Or not... \n\n We don't know really.",
							"Coming soon", JOptionPane.INFORMATION_MESSAGE,
							soonTM);
		} else if (source == fileReset) {
			guiIO.replay();
		} else if (source == fileExit) {
			guiIO.closeGame();
			System.exit(0);
		} else if (source == fileHome) {
			guiIO.goHome();
		}

	}
}
