package fr.iut.adaugustaperangusta.view.gui;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.utils.CreateMap;
import fr.iut.adaugustaperangusta.view.View;

public class GuiIO implements View {

	private static final String DEFAULT_MAP = "Test.txt";
	private MainWindow mainWindow;
	private Game game;
	private VictoryWindow victory;
	private HomeWindow homeWindow;
	private String file;

	public GuiIO(Game game) {
		this.game = null;
		this.mainWindow = null;
		this.victory = null;
		this.homeWindow = null;
		this.file = DEFAULT_MAP;
	}

	public void creatGame() {
		this.game = new Game(CreateMap.importFromFile(file), true);
	}

	public void displayMap() {
		this.mainWindow.repaint();
		this.tryWin();
	}

	public void displayWin() {
		victory = new VictoryWindow(mainWindow, this);

	}

	@Override
	public void play() {
		this.creatGame();
		this.homeWindow = new HomeWindow(this);
	}

	public void move(RelativePos dirDeptTest) {
		if (game.isCharacterMovable(dirDeptTest)) {
			try {
				game.getMap().moveTrav(game.getCharacter().getPositionTrav(),
						game.getCharacter().posToCheck(dirDeptTest));// tableau
				game.getCharacter().move(dirDeptTest);// positions
			} catch (OutOfMapException e) {
			}
		}
	}

	public void tryWin() {
		if (game.isWon())
			this.displayWin();
	}

	public int endGame() {

		return 3;
	}

	public void replay() {
		if (this.victory != null)
			this.victory.dispose();
		if (this.mainWindow != null)
			this.mainWindow.dispose();
		if (this.homeWindow != null)
			this.homeWindow.dispose();
		this.homeWindow = null;
		this.victory = null;
		this.homeWindow = null;

		this.creatGame();
		this.lunchGame();

	}

	public void closeWindow() {
		if (this.victory != null)
			this.victory.dispose();
		if (this.mainWindow != null)
			this.mainWindow.dispose();
		if (this.homeWindow != null)
			this.homeWindow.dispose();
		this.homeWindow = null;
		this.victory = null;
		this.homeWindow = null;
	}

	public void closeGame() {
		if (this.victory != null)
			this.victory.dispose();
		if (this.mainWindow != null)
			this.mainWindow.dispose();
		if (this.homeWindow != null)
			this.homeWindow.dispose();
		this.homeWindow = null;
		this.victory = null;
		this.homeWindow = null;
		System.exit(0);
	}

	public void lunchGame() {
		this.mainWindow = new MainWindow(game.getMap(),
				new MyKeyListener(this), this);
		if (this.homeWindow != null) {
			this.homeWindow.dispose();
			this.homeWindow = null;
		}

	}

	public void goHome() {

		if (this.mainWindow != null)
			this.mainWindow.dispose();
		if (this.victory != null)
			this.victory.dispose();
		this.mainWindow = null;
		this.victory = null;
		this.play();
	}

	public void selectFile() {
		if (SelectFile.fileSelection() != null)
			this.file = SelectFile.fileSelection().getName();
		this.goHome();
	}

	public Map getMap() {
		return this.game.getMap();
	}
}
