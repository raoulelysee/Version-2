/*
 * Version préliminaire soumise dans le but principal d'obtenir 
 * l'opinion du professeur à propos de l'approche utilisé.
 * Il manque enconre plusieurs détails dans le code (dont une classe
 * Validation pour valider les données d'entrée, etc, et d'autres améliorations
 * dans le traitement du passage de donnés en arguments
 * devront être fait). Il y a des questions a poser au Professeur par rapport
 * au passage d'une adresse relatif
 */
package tp1vprofequipe20;

import entree.Reclamation;
import net.sf.json.JSONObject;
import sortie.FichierSortie;

/**
 *
 * @author fernando
 */
public class TP1vProfEquipe20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Arguments invalides");
            System.exit(0); 
        } else {
            try {

                JSONObject objSortie = new JSONObject();
                Reclamation demande = new Reclamation(args[0]);
                FichierSortie sortie = new FichierSortie(demande);

                objSortie = sortie.creerObjetSortie();
                sortie.creerFichierSortie(objSortie, args[1]);
                System.out.println(objSortie);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
}
