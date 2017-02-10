package projetBanque;

/**
 * La classe des comptes carte de cr�dit, h�rit�s des comptes
 * 
 * @author Romain
 *
 */
public class CarteCredit extends Compte {

	/**
	 * Constructeur des comptes cartes de cr�dit, h�istant du constructeur Compte
	 * @param lib Le libell� du compte
	 * @param tit Le client titulaire du compte
	 * 
	 * @see Compte#Compte(String, Client)
	 */
	public CarteCredit(String lib, Client tit) {
		super(lib, tit);
	}
	
	/**
	 * Fonction toString() �quivalente � celle de la classe Compte
	 * 
	 * @return Un String affichant toutes les informations relatives au compte
	 * 
	 * @see Compte#toString()
	 */
	public String toString() {
		return super.toString();
	}

}
