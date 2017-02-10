package projetBanque;

/**
 * Classe des comptes epargnes, h�ritant des comptes r�mun�r�s
 * 
 * @author Romain
 *
 */
public class CompteEpargne extends CompteRemunere {

	/**
	 * Constructeur h�ritant du constructeur CompteRemunere
	 * 
	 * @param lib Le libell� du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de r�mun�ration du solde
	 * @param soldeP Le solde plafond
	 * 
	 * @see CompteRemunere#CompteRemunere(String, Client, double, double)
	 */
	public CompteEpargne(String lib, Client tit, double tauxR, double soldeP) {
		super(lib, tit, tauxR, soldeP);
	}
	
	/**
	 * Fonction toString() �quivalente � celle de la classe CompteRemunere
	 * 
	 * @return Un String affichant toutes les informations relatives au compte r�mun�r�
	 * 
	 * @see CompteRemunere#toString()
	 */
	public String toString() {
		return super.toString();
	}

}
