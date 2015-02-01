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
public class ContratC extends ContratA{
    
    public ContratC(String valSoin, String argent){ 
        
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
       return 0.9 * parserMontant();
    }
    
    
}
