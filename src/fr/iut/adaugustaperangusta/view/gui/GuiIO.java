package fr.iut.adaugustaperangusta.view.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;
import fr.iut.adaugustaperangusta.exceptions.OutOfMapException;
import fr.iut.adaugustaperangusta.utils.CreateMap;
import fr.iut.adaugustaperangusta.view.View;

public class GuiIO implements View {

	private MainWindow mainWindow;
	private Game game;
	private VictoryWindow victory;
	
	public GuiIO(Game game)
	{
		this.game = game;
		this.mainWindow = new MainWindow(game.getMap(),new MyKeyListener(this),this);
		this.victory = null;
	}
	@Override
	public void displayMap(Map map) {
			
	}

	public void displayMap(){
		this.mainWindow.repaint();
		this.tryWin();
	}
	@Override
	public void displayWin() {
		victory= new VictoryWindow(mainWindow,this);

	}

	@Override
	public void displayInvalideMove(RelativePos dirDeptTest, Traveller character) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayInvalideInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public RelativePos getMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		

	}

	public void move(RelativePos dirDeptTest){
		if (game.isCharacterMovable(dirDeptTest))
		{
			try
			{
				game.getMap().moveTrav(game.getCharacter().getPositionTrav(), game.getCharacter().posToCheck(dirDeptTest));//tableau
				game.getCharacter().move(dirDeptTest);//positions
			} catch (OutOfMapException e)
			{
			}		
		} 
	}

	public void tryWin(){
		if(game.isWon()) this.displayWin();
	}
	
	public int endGame(){
		
		return 3;
	}
	
	public void replay(){
		Game game = new Game(CreateMap.importFromFile("Test.txt"),true);
		this.closeGame();
	}
	
	public void closeGame(){
		if(this.victory != null) this.victory.dispose();
		this.mainWindow.dispose();
	}
}
