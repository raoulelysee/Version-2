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
public class ContratB extends ContratA {
    
    public ContratB(String valSoin, String argent){
        
        super(valSoin, argent);
    }
    
    public double cinquanteP(){
        double montantInitial = parserMontant();
        return 0.5 * montantInitial;
    }
    public double septanteP(){
        double montantInitial = parserMontant();
        return 0.7 * montantInitial;
    }   
    /**
     * On redefinie la methode calcul() de la classe parent
     * ContratA
     * @return:
     * Double Le Montant a rembourser.
     * 
     */
    @Override
    public double calcul(){
        int valeurSoin = parserSoin();
        double res = 1.0;
        
         if(valeurSoin >= 300 && valeurSoin <= 399){
             res = cinquanteP();
         }else{
             
             switch (valeurSoin) {

                 case 0:
                     res = cinquanteP();
                     res = (res < 40.0) ? res:40.0;
                     break;
                 case 100:
                     res = cinquanteP();
                     res = (res < 50.0) ? res:50.0;
                     break;
                 case 200:
                     res = parserMontant();
                     res = (res < 70.0) ? res:70.0;
                     break;
                 case 400:
                     res = 0.0;
                     break;
                 case 500:
                     res = cinquanteP();
                     res = (res < 50.0) ? res:50.0;
                     break;
                 case 600:
                     res = parserMontant();
                     break;                    
                 case 700:
                     res = septanteP();
                     break;
                 default:                     
                     break;

             }
         }      
         return res;
        
    }
    
}
