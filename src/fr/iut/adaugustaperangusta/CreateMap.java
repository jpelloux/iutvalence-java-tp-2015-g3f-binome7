package fr.iut.adaugustaperangusta;

import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* TODO Translate. */
/**
 * Librairie d'import de Map.
 * Contient les méthodes d'importation de Map depuis eds fichiers.
 *
 * @author jpelloux
 * @version TODO
 */
public final class CreateMap {
    /** Empty constructor. */
    private CreateMap() { /* NOTHING */ }

    /* TODO Translate. */
    /**
     * Import Map depuis un fichier.
     * TEST EN COURS
     * ATTENTION le joueur n'est pas inscrit dans la map!
     *
     * @param filename Le fichier texte source.
     */
    public static Map importFromFile(final String filename) {
        final Map map = new Map();
        try (final FileInputStream fis = new FileInputStream(new File(filename))) {
            // On crée un tableau de byte pour indiquer le nombre de bytes lus à chaque tour de boucle
            byte[] buf = new byte[map.getWidth() + 1];
            // On crée une variable de type int pour y affecter le résultat de la lecture
            // Vaut -1 quand c'est fini
            int n = 0;
            int indiceLigne = 0;
            // Tant que l'affectation dans la variable est possible, on boucle
            // Lorsque la lecture du fichier est terminée l'affectation n'est
            // plus possible !
            // On sort donc de la boucle
            while ((n = fis.read(buf)) >= 0) {
                int indiceColonne = 0;
                // On affiche ce qu'a lu notre boucle au format byte et au
                // format char
                for (byte bit : buf) {
                    System.out.print((char) bit);
                    // System.out.print(indiceLigne+","+ indiceColonne);
                    //TODO Supression des caractère de fin de chaine (if == ....
                    Cell cellAAjouter = new Cell(new Floor());
                    if ((char) bit == 'x') { cellAAjouter = new Cell(new Wall()); }
                    if ((char) bit == 'o') { cellAAjouter = new Cell(new Target()); }
                    if ((char) bit == 'b') { cellAAjouter = new Cell(new Floor(), new Block()); }
                    if ((indiceLigne < map.getHeight()) && (indiceColonne < map.getWidth())) {
                        map.setCell(indiceLigne, indiceColonne, cellAAjouter);
                    }
                    //	               map.setTabCell(indiceLigne%10 , indiceColonne%nbColonnes,cellAAjouter);
                    indiceColonne++;
                }
                //Nous réinitialisons le buffer à vide
                //au cas où les derniers byte lus ne soient pas un multiple de 8
                //Ceci permet d'avoir un buffer vierge à chaque lecture et ne pas avoir de doublon en fin de fichier
                buf = new byte[map.getWidth() + 1];
                indiceLigne++;
            }
            System.out.println("Copie termin�e !");
        }
        catch (final IOException e) {
            // Celle-ci se produit lors d'une erreur d'écriture ou de lecture
            e.printStackTrace();
            return null;
        }
        return map;
    }
}
