package fr.iut.adaugustaperangusta.view.gui;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;
import fr.iut.adaugustaperangusta.utils.CreateMap;
import fr.iut.adaugustaperangusta.view.View;

public class GuiIO implements View {

	private MainWindow mainWindow;
	
	public GuiIO(Game game)
	{
		this.mainWindow = new MainWindow(game.getMap());
	}
	@Override
	public void displayMap(Map map) {
			
	}

	@Override
	public void displayWin() {
		// TODO Auto-generated method stub

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

}
