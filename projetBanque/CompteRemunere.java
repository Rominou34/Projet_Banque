package projetBanque;

/**
 * Classe des comptes r�mun�r�s, h�rit�s des comptes.
 * <p>Tous les comptes r�mun�r�s poss�dent un taux de r�mun�ration et un solde plafond</p>
 * 
 * @author Romain
 *
 */
public class CompteRemunere extends Compte {

	/**
	 * Le taux de r�mun�ration du compte
	 */
	private double tauxRemun;
	
	/**
	 * Le solde plafond du compte
	 */
	private double soldePlaf;
	
	
	/**
	 * Constructeur h�ritant du constructeur Compte
	 * 
	 * @param lib Le libell� du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de r�mun�ration
	 * @param soldeP Le solde plafond du compte
	 * 
	 * @see Compte#Compte(String, Client)
	 */
	public CompteRemunere(String lib, Client tit, double tauxR, double soldeP) {
		super(lib, tit);
		this.tauxRemun = tauxR;
		this.soldePlaf = soldeP;
	}
	
	/**
	 * Fonction toString() h�ritant de celle de Compte mais avec des attributs en plus
	 * ( le taux de r�mun�ration et le solde plafond )
	 * 
	 * @return Un String affichant toutes les informations relatives au compte r�mun�r�
	 * 
	 * @see Compte#toString()
	 */
	public String toString() {
		return super.toString() + "\nTaux de r�mun�ration: " + this.tauxRemun +
				"\nSolde plafond: " + this.soldePlaf;
	}
	
	/**
	 * Fonction crediter de compte red�finie pour fonctionner avec le solde plafond, afin
	 * de g�rer les exceptions dans le cas du d�passement du solde plafond
	 * 
	 * @param val La valeur du montant de l'op�ration
	 * 
	 * @throws OperationBancaireException Si le solde plafond est d�pass�
	 */
	public void crediter(double val) throws OperationBancaireException {
		if(this.solde + val > soldePlaf) {
			this.historique.add(new Credit(Statut.KO, val));
			throw new OperationBancaireException(false, this.solde, val, soldePlaf);
		}
		else {
			super.crediter(val);
		}
	}
	
	/**
	 * Fonction crediter ayant comme parametre une op�ration
	 * 
	 * @param op L'op�ration concern�e par le cr�dit
	 * 
	 * @return Un bool�en en fonction du succ�s de l'op�ration
	 */
	public boolean crediter(Operation op) {
		if(this.solde + op.getMontant() > this.soldePlaf) {
			op.modifierStatut(Statut.KO);
			this.historique.add(op);
			return false;
		}
		else {
			this.solde += op.getMontant();
			op.modifierStatut(Statut.OK);
			this.historique.add(op);
			return true;
		}
	}
	
	/**
	 * Fonction permettant de savoir si un cr�dit est possible sur ce compte r�mun�r�
	 * 
	 * @param val La valeur du cr�dit
	 * @return Un bool�en en fonction de la possibilit� du cr�dit
	 */
	public boolean peutCrediter(double val) {
		return (this.solde + val <= this.soldePlaf);
	}

}
