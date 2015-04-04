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
		Map map = new Map(10,20);
		CreateMap.importMap("Test.txt",map);
		System.out.println(map);
	}
	
}
