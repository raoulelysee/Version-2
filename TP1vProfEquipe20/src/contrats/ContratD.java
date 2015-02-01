/*
 * Classe pour calculer les remboursements
 * Classe qui herite de ContratA
 * @param:
 * String valSoin: Un String correspondant au type de soin
 * String argent: Un String correspondant au montant demande
 * @Return: LE but principal c'est de retourner le montant a rembourser
 * Le calcul est fait dans la methode calcul()
 */
package contrats;

/**
 *
 * @author fernando
 */
public class ContratD extends ContratA{
    
    public ContratD(String valSoin, String argent){ 
        
        super(valSoin, argent);
        
    }
    
    /**
     * On redefinie la methode calcul() de la classe parent
     * ContratA
     * @return:
     * Double Le Montant a rembourser.
     */
    @Override
    public double calcul(){

        int valeurSoin = parserSoin();
        double res = 1.0;
        
         if(valeurSoin >= 300 && valeurSoin <= 399){
             res = parserMontant();
         }else{
             switch (valeurSoin) {
                 case 0:
                     res = parserMontant();
                     res = (res < 85.0) ? res:85.0;
                     break;
                 case 100:
                     res = parserMontant();
                     res = (res < 75.0) ? res:75.0;
                     break;
                 case 200:
                     res = parserMontant();
                     res = (res < 100.0) ? res:100.0;
                     break;
                 case 400:
                     res = parserMontant();
                     res = (res < 65.0) ? res:65.0;
                     break;
                 case 500:
                     res = parserMontant();
                     res = (res < 75.0) ? res:75.0;
                     break;
                 case 600:
                     res = parserMontant();
                     res = (res < 100.0) ? res:100.0;
                     break;                    
                 case 700:
                     res = parserMontant();
                     res = (res < 90.0) ? res:90.0;
                     break;
                 default:                     
                     break;
             }
         }
        
        return res;
    } 
    
}
