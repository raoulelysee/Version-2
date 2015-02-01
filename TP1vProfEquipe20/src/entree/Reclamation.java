/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entree;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import outils.FileReader;

/**
 *
 * @author fernando
 */
public class Reclamation {
    
    private String chemin;    
    private String demande;
    private JSONObject objJSON;
    private String tabStringDansDemande;
    private JSONArray tabJSONDansDemande;
    private String contrat;
    private String mois;
    private String client;
    
    public Reclamation(String filePath) throws FileNotFoundException,IOException {
        
        this.chemin = filePath;        
        this.demande = FileReader.loadFileIntoString(this.chemin, "UTF-8");
        this.objJSON = JSONObject.fromObject(this.demande);
        this.client = this.objJSON.getString("client");
        this.contrat = this.objJSON.getString("contrat");
        this.mois = this.objJSON.getString("mois");
        this.tabStringDansDemande = this.objJSON.getString("reclamations");
        this.tabJSONDansDemande = JSONArray.fromObject(this.tabStringDansDemande);        
        
    }    
    public JSONObject getReclamation(){
        return this.objJSON;
    }
    public String getClient(){
        return this.client;
    }
    public String getContrat(){
        return this.contrat;
    }
    public String getMois(){
        return this.mois;
    }
    public JSONArray getTableauReclamations(){
        return this.tabJSONDansDemande;
    }
    
}
