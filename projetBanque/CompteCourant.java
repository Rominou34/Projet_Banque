package projetBanque;

/**
 * La classe des comptes courants, h�rit�s des comptes
 * 
 * @author Romain
 *
 */
public class CompteCourant extends Compte {

	/**
	 * Constructeur des comptes courants, h�rit� du constructeur Compte
	 * @param lib Le libell� du compte
	 * @param tit Le client titulaire du compte
	 * 
	 * @see Compte#Compte(String, Client)
	 */
	public CompteCourant(String lib, Client tit) {
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
