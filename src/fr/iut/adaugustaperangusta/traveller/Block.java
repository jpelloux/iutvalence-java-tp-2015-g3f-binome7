/**
 * Objets en mouvement.
 */
package fr.iut.adaugustaperangusta.traveller;

/**
 * Bloc déplaçable.
 * Le joueur peut les <strong>pousser</strong>.
 * Le but est d'amener tous les Blocks sur des Targets.
 */
public class Block extends Traveller
{
	/**
	 * Méthode d'affichage.
	 * Affiche le caractère 'O' sur la sortie standard.
	 * Ce caractère s'affiche au centre de chaque case.
	 */
	@Override
	public String toString()
	{
		return "O";
	}
	
}
