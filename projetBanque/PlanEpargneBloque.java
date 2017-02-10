package projetBanque;

import java.util.*;

/**
 * La classe des comptes à plan épargne bloqué, héritant des comptes rémunérés
 * 
 * @author Romain
 *
 */
public class PlanEpargneBloque extends CompteRemunere {

	/**
	 * La date de mise à disposition des fonds. Aucune opération n'est autorisée avant
	 * cette date.
	 */
	private Date dateDispo;
	
	
	/**
	 * Constructeur héritant de CompteRemunere
	 * 
	 * @param lib Le libellé du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de rémunération
	 * @param soldeP Le solde plafond
	 * @param dateD La date de mise à disposition des fonds
	 * 
	 * @see CompteRemunere#CompteRemunere(String, Client, double, double)
	 */
	public PlanEpargneBloque(String lib, Client tit, double tauxR, double soldeP, Date dateD) {
		super(lib, tit, tauxR, soldeP);
		this.dateDispo = dateD;
	}
	
	/**
	 * Fonction toString() équivalente à celle de la classe CompteRemunere mais avec un attribut en plus
	 * ( la date de mise à disposition des fonds )
	 * 
	 * @return Un String affichant toutes les informations relatives au compte
	 * 
	 * @see CompteRemunere#toString()
	 */
	public String toString() {
		return super.toString() + "\nDate de mise à disposition des fonds: " + this.dateDispo;
	}

}
