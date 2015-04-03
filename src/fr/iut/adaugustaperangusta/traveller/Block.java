/**
 * Objets en mouvement.
 */
package fr.iut.adaugustaperangusta.traveller;

/**
 * Bloc déplaçable.
 * Le joueur peut les <strong>pousser</strong>.
 * Le but est de les amener sur les Targets.
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
