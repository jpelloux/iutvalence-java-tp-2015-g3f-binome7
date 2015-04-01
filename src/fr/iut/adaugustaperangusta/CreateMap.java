package fr.iut.adaugustaperangusta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import fr.iut.adaugustaperangusta.overlay.Floor;
import fr.iut.adaugustaperangusta.overlay.Target;
import fr.iut.adaugustaperangusta.overlay.Wall;
import fr.iut.adaugustaperangusta.traveller.Block;

/**  Test d'importation d'une map en .txt
 * @author pellouju
 *
 * EN COURS
 */

public class CreateMap {
	public static final void importMap(String file, Map map){
		FileInputStream fis = null;
	      
	      try {
	         // On instancie nos objets :
	         // fis va lire le fichier
	         fis = new FileInputStream(new File("Test.txt"));
	         
	         // On cr�e un tableau de byte pour indiquer le nombre de bytes lus �
	         // chaque tour de boucle
	         byte[] buf = new byte[map.getWidth()];
	         // On cr�e une variable de type int pour y affecter le r�sultat de
	         // la lecture
	         // Vaut -1 quand c'est fini
	         int n = 0;
	         int indiceLigne = 0;
	         int indiceColonne;
	         // Tant que l'affectation dans la variable est possible, on boucle
	         // Lorsque la lecture du fichier est termin�e l'affectation n'est
	         // plus possible !
	         // On sort donc de la boucle
	         Cell cellAAjouter; 
	         while ((n = fis.read(buf)) >= 0) {
	        	 indiceColonne =0;
	            // On affiche ce qu'a lu notre boucle au format byte et au
	            // format char
	            for (byte bit : buf) {
	               System.out.print((char) bit);
	              // System.out.print(indiceLigne+","+ indiceColonne);
	               
	                //TODO Supression des caract�re de fin de chaine (if == ....
	               cellAAjouter= new Cell(new Floor());
	               if((char)bit == 'x') cellAAjouter= new Cell(new Wall());
	               if((char)bit == 'o') cellAAjouter= new Cell(new Target());
	               if((char)bit == 'b') cellAAjouter= new Cell(new Floor(), new Block());
	               if ((indiceLigne < map.getHeight())&&(indiceColonne <map.getWidth()))
	               {
	               map.setTabCell(indiceLigne , indiceColonne,cellAAjouter);
	               }
//	               map.setTabCell(indiceLigne%10 , indiceColonne%nbColonnes,cellAAjouter);

	               indiceColonne++;
	            }
	            //Nous r�initialisons le buffer � vide
	            //au cas o� les derniers byte lus ne soient pas un multiple de 8
	            //Ceci permet d'avoir un buffer vierge � chaque lecture et ne pas avoir de doublon en fin de fichier
	            buf = new byte[map.getWidth()];
	            indiceLigne ++;
	         }
	         System.out.println("Copie termin�e !");
	      } catch (FileNotFoundException e) {
	         // Cette exception est lev�e si l'objet FileInputStream ne trouve
	         // aucun fichier
	         e.printStackTrace();
	      } catch (IOException e) {
	         // Celle-ci se produit lors d'une erreur d'�criture ou de lecture
	         e.printStackTrace();
	      } finally {
	         // On ferme nos flux de donn�es dans un bloc finally pour s'assurer
	         // que ces instructions seront ex�cut�es dans tous les cas m�me si
	         // une exception est lev�e !
	         try {
	            if (fis != null)
	               fis.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }

	      }
	}
	
}
