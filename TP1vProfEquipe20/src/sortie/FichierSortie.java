/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortie;

import contrats.ContratA;
import contrats.ContratB;
import contrats.ContratC;
import contrats.ContratD;
import entree.Reclamation;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author fernando
 */
public class FichierSortie {
    
    private Reclamation demande;  
    
    public FichierSortie(Reclamation demande){
        
        this.demande = demande;        
        
        
    }
    public JSONObject creerObjetCourantReclamation(int soin, String mois, String montant){
        
        JSONObject objCourant = new JSONObject();
        objCourant.accumulate("soin", soin);
        objCourant.accumulate("date", mois);
        objCourant.accumulate("montant", montant);
        return objCourant;
        
    }
    public JSONObject creerObjetSortie(){
        
        JSONObject objSortie = new JSONObject();
        JSONObject objSortieCourDansTab = new JSONObject();
        JSONArray tableauReclamation = this.demande.getTableauReclamations();
        JSONArray tableauSortie = new JSONArray();
        ContratA contrat = null;
        String contratDemande = this.demande.getContrat();
        String soinCourant;
        String montantCourant;
        String rembFormate;
        double remboursement;
        int soinObjCourant;
        String dateCourant;
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits ( 2 );
        format.setMinimumFractionDigits ( 2 );
        
        for(int i = 0; i < tableauReclamation.size(); i++){
            
            JSONObject objCourant = tableauReclamation.getJSONObject(i); 
            soinCourant = objCourant.getString("soin");
            montantCourant = objCourant.getString("montant");
            
            soinObjCourant = Integer.parseInt(soinCourant);
            dateCourant = objCourant.getString("date");
            
            switch (contratDemande){
            
            case "A":
                contrat = new ContratA(soinCourant, montantCourant);
                break;
            case "B":
                contrat = new ContratB(soinCourant, montantCourant);
                break;
            case "C":
                contrat = new ContratC(soinCourant, montantCourant);
                break;
            case "D":
                contrat = new ContratD(soinCourant, montantCourant);
                break;
            default:
                break;
            }
            
            remboursement = contrat.calcul();
            rembFormate = format.format(remboursement);
            rembFormate = rembFormate + '$';
            
            objSortieCourDansTab = creerObjetCourantReclamation(soinObjCourant,dateCourant,rembFormate); 
            tableauSortie.add(objSortieCourDansTab); 
            
        }
        objSortie.accumulate("client",this.demande.getClient());       
        objSortie.accumulate("mois",this.demande.getMois());
        objSortie.accumulate("remboursements",tableauSortie);
        
        
        return objSortie;
    }
    public void creerFichierSortie(JSONObject objet, String cheminSortie) throws IOException{
        
        JSONObject obj = objet;
        String chemin = cheminSortie;
        try (FileWriter file = new FileWriter(chemin)) {
            file.write(obj.toString());            
            file.close();
        }catch (IOException ex){
            
            System.out.println(ex.getMessage());
        }
    }
}
