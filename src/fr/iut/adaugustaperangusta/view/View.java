package fr.iut.adaugustaperangusta.view;

import fr.iut.adaugustaperangusta.controller.Game;
import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;

public interface View
{
		public abstract void displayMap(Map map);

		public void displayWin();
		
		public void displayInvalideMove(RelativePos dirDeptTest,Traveller character);

		public void displayInvalideInput();

		public RelativePos getMove();
	
		public void play();

}
