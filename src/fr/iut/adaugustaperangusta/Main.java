package fr.iut.adaugustaperangusta;

/**
 * Point d'entrée du programme.
 */
public class Main
{
	/**
	 * Point d'entrée du programme.
	 */
	public static void main(String[] args)
	{
//		Map map = new Map(10,20);
//		CreateMap.importMap("Test.txt",map);
		Map map = new Map('a');
		Position pos = new Position(2,1);
		System.out.println(map.getTraveller(pos).getName());
		System.out.println(map);
		
	}
	
}
