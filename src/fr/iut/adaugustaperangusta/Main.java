//TODO trouver comment supprimer des todo en masse.
/* TODO Convention java : package en minuscule. */
package fr.iut.adaugustaperangusta;

/* TODO JAVADOC. */
public class Main
{
	/* TODO JAVADOC. */
	public static void main(String[] args)
	{
		// TODO Main
		Map map = new Map(10,20);
		
		CreateMap.importMap("Test.txt", 20,map);
		System.out.println(map);
	}
	
}
