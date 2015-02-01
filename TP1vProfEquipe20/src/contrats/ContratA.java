/*
 * Classe pour calculer les remboursements
 * Classe Parent pour le reste des contrats
 * Les autres contrats vont heriter de ContratA afin de profiter
 * du polymorfisme lors du passage en parametre des objets Contrat
 * quand ils seront appele par d'autres methodes
 * @param:
 * String valSoin: Un String correspondant au type de soin
 * String argent: Un String correspondant au montant demande
 * @Return: Le but principal c'est de retourner le montant a rembourser
 * Le calcul est fait dans la methode calcul()
 */
package contrats;

/**
 *
 * @author fernando
 */
public class ContratA {
    
    private String soin;
    private String montant;
    private final int valDefaut = 1; //Une valeur quelconque differente de toutes les soins
    private final double remboursementDefaut = 0.0;
    
    public ContratA(String valSoin, String argent){
        
        this.soin = valSoin;
        this.montant = argent;
        
    }
    
    public int parserSoin(){
        try{
            return Integer.parseInt(soin);
        }catch (NumberFormatException e){
            return valDefaut;
        }       
        
    }
    
    /*
    *   Ici, on suposse que le string argent est deja valide
    *   (ce qu'on dvrait faire dans un autre package (toutes les validations)
    *   et que argent finisse bien par $. Puis, on l'enleve avant le parser
    */
    public double parserMontant(){
        
        String nouveauMontant = montant.substring(0, montant.length() - 1);
        try{
           return Double.parseDouble(nouveauMontant);
        }catch (NumberFormatException e){
            return remboursementDefaut;
        }
    }
    public double vingtcinqueP(){
        double montantInitial = parserMontant();
        return 0.25f * montantInitial;
    }
   
    
     public double quaranteP(){
        double montantInitial = parserMontant();
        return 0.40f * montantInitial;
    }
    
     public double calcul(){
         
         int valeurSoin = parserSoin();
         double res = 1.0;
         
         if(valeurSoin >= 300 && valeurSoin <= 399){
             res = 0.0;
         }else{
             
             switch (valeurSoin) {

                 case 0:
                 case 100:
                 case 200:
                 case 500:
                     res = vingtcinqueP();
                     break;
                 case 600:
                     res = quaranteP();
                     break;
                 case 400:
                 case 700:
                     res = 0.0;
                     break;
                 default:                     
                     break;

             }
         }      
         return res;  //valeur arbitraire (flag) qui doit correspondre au mss d'erreur     
     }
    
    
}
