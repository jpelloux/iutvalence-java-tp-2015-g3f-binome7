package fr.iut.adaugustaperangusta.view.console;

import fr.iut.adaugustaperangusta.core.Map;
import fr.iut.adaugustaperangusta.core.RelativePos;
import fr.iut.adaugustaperangusta.core.traveller.Traveller;

public class StrDisplay
{
	public static final void displayMap (Map map)
	{
		System.out.println(map);
	}
	
	public static final void displayWin()
	{
		System.out.println("Good Job!");
	}
	
	public static final void displayInvalideMove(RelativePos dirDeptTest,Traveller character)
	{
		System.out.println("-------------");
		System.out.println("Dpt imp"); // Test moche
		System.out.println(dirDeptTest);
		System.out.println(character.getPositionTrav());
		System.out.println(character.posToCheck(dirDeptTest));
	}


	public static final void displayInvalideInput()
	{
		System.out.println("Invalid Input");
	}
}
