package projetBanque;

/**
 * Classe des comptes epargnes, héritant des comptes rémunérés
 * 
 * @author Romain
 *
 */
public class CompteEpargne extends CompteRemunere {

	/**
	 * Constructeur héritant du constructeur CompteRemunere
	 * 
	 * @param lib Le libellé du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de rémunération du solde
	 * @param soldeP Le solde plafond
	 * 
	 * @see CompteRemunere#CompteRemunere(String, Client, double, double)
	 */
	public CompteEpargne(String lib, Client tit, double tauxR, double soldeP) {
		super(lib, tit, tauxR, soldeP);
	}
	
	/**
	 * Fonction toString() équivalente à celle de la classe CompteRemunere
	 * 
	 * @return Un String affichant toutes les informations relatives au compte rémunéré
	 * 
	 * @see CompteRemunere#toString()
	 */
	public String toString() {
		return super.toString();
	}

}
