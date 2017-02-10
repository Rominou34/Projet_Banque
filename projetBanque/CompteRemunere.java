package projetBanque;

/**
 * Classe des comptes rémunérés, hérités des comptes.
 * <p>Tous les comptes rémunérés possèdent un taux de rémunération et un solde plafond</p>
 * 
 * @author Romain
 *
 */
public class CompteRemunere extends Compte {

	/**
	 * Le taux de rémunération du compte
	 */
	private double tauxRemun;
	
	/**
	 * Le solde plafond du compte
	 */
	private double soldePlaf;
	
	
	/**
	 * Constructeur héritant du constructeur Compte
	 * 
	 * @param lib Le libellé du compte
	 * @param tit Le client titulaire du compte
	 * @param tauxR Le taux de rémunération
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
	 * Fonction toString() héritant de celle de Compte mais avec des attributs en plus
	 * ( le taux de rémunération et le solde plafond )
	 * 
	 * @return Un String affichant toutes les informations relatives au compte rémunéré
	 * 
	 * @see Compte#toString()
	 */
	public String toString() {
		return super.toString() + "\nTaux de rémunération: " + this.tauxRemun +
				"\nSolde plafond: " + this.soldePlaf;
	}
	
	/**
	 * Fonction crediter de compte redéfinie pour fonctionner avec le solde plafond, afin
	 * de gérer les exceptions dans le cas du dépassement du solde plafond
	 * 
	 * @param val La valeur du montant de l'opération
	 * 
	 * @throws OperationBancaireException Si le solde plafond est dépassé
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
	 * Fonction crediter ayant comme parametre une opération
	 * 
	 * @param op L'opération concernée par le crédit
	 * 
	 * @return Un booléen en fonction du succès de l'opération
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
	 * Fonction permettant de savoir si un crédit est possible sur ce compte rémunéré
	 * 
	 * @param val La valeur du crédit
	 * @return Un booléen en fonction de la possibilité du crédit
	 */
	public boolean peutCrediter(double val) {
		return (this.solde + val <= this.soldePlaf);
	}

}
