package projetBanque;

import java.util.*;

/**
 * La classe des comptes � plan �pargne bloqu�, h�ritant des comptes r�mun�r�s
 * 
 * @author Romain
 *
 */
public class PlanEpargneBloque extends CompteRemunere {

	/**
	 * La date de mise � disposition des fonds. Aucune op�ration n'est autoris�e avant
	 * cette date.
	 */
	private Date dateDispo;
	
	
	/**
	 * Constructeur h�ritant de CompteRemunere
	 * 
	 * @param lib Le libell� du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de r�mun�ration
	 * @param soldeP Le solde plafond
	 * @param dateD La date de mise � disposition des fonds
	 * 
	 * @see CompteRemunere#CompteRemunere(String, Client, double, double)
	 */
	public PlanEpargneBloque(String lib, Client tit, double tauxR, double soldeP, Date dateD) {
		super(lib, tit, tauxR, soldeP);
		this.dateDispo = dateD;
	}
	
	/**
	 * Fonction toString() �quivalente � celle de la classe CompteRemunere mais avec un attribut en plus
	 * ( la date de mise � disposition des fonds )
	 * 
	 * @return Un String affichant toutes les informations relatives au compte
	 * 
	 * @see CompteRemunere#toString()
	 */
	public String toString() {
		return super.toString() + "\nDate de mise � disposition des fonds: " + this.dateDispo;
	}

}
