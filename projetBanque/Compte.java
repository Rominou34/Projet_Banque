package projetBanque;

import java.util.*;

/**
 * La classe Compte permet de manipuler les comptes bancaires
 * <p>
 * Un compte bancaire peut être soit un compte courant, soit un compte
 * carte crédit, soit un compte rémunéré.
 * <p>
 * Tout compte bénéficie des caractéristiques suivantes :
 * <ul><li>Possède un numéro identifiant
 * <li>Possède un libellé
 * <li>Possède un solde
 * <li>Appartient à un client
 * </ul>
 * 
 * @author Romain
 *
 */
public class Compte {
	
	/**
	 * Le dernier id attribué, permettant d'attribuer l'id du compte actuel
	 * en fonction de l'id du compte le plus récent. L'attribut est
	 * initialisé à 0
	 */
	private static int lastCompteId=0;
	
	/**
	 * Le numéro identifiant du compte, non modifiable, attribué lors de
	 * la création du compte.
	 */
	private int numId;
	
	/**
	 * Le libellé du compte
	 */
	private String libelle;
	
	/**
	 * Le solde du compte, consultable et modifiable lors des virements
	 * et autres opérations bancaires. Accessible par toutes les classes du package
	 */
	double solde;
	
	/**
	 * Le client titulaire du compte
	 */
	private Client titulaire;

	/**
	 * L'historique des opérations effectuées sur le compte
	 */
	ArrayList<Operation> historique;
	
	
	/**
     * Constructeur du Compte
     * <p>L'id du compte est automatiquement calculé en fonction du lastCompteId afin
     * d'éviter les doublons. A la fin on utilise la fonction ajouterCompte de la classe
     * Client afin d'ajouter le ocmpte à la liste des comptes du client</p>
     * 
     * @param lib Le libellé du compte
     * @param tit Le titulaire du compte
     * 
     * @see Client#ajouterCompte(Compte)
     */
	public Compte(String lib, Client tit) {
		this.numId = ++lastCompteId;
		this.libelle = lib;
		this.titulaire = tit;
		this.solde = 0;
		this.historique = new ArrayList<Operation>();
		
		tit.ajouterCompte(this);;
	}
	
	
	/**
	 * Fonction permettant de débiter le solde d'un compte d'une valeur passée en paramètre
	 * 
	 * @param val Le montant à débiter
	 * 
	 * @throws OperationBancaireException Si le montant est négatif ou nul, ou si le solde est
	 *  insuffisant
	 *  
	 */
	public void debiter(double val) throws OperationBancaireException {
		if(val <= 0 || this.solde-val < 0) {
			this.historique.add(new Debit(Statut.KO, val));
			throw new OperationBancaireException(true, this.solde, val);
		}
		else {
			this.solde -= val;
			this.historique.add(new Debit(Statut.OK, val));
		}
	}
	
	/**
	 * Fonction debiter ayant comme parametre une operation
	 * 
	 * @param op L'opération concernée par le débit
	 * 
	 * @return Un booléen indiquant le succès ou l'échec de l'opération
	 */
	public boolean debiter(Operation op) {
		if(this.solde < op.getMontant()) {
			op.modifierStatut(Statut.KO);
			this.historique.add(op);
			return false;
		}
		else {
			op.modifierStatut(Statut.OK);
			this.solde -= op.getMontant();
			this.historique.add(op);
			return true;
		}
	}
	
	/**
	 * Fonction permettant de savoir si un débit est possible
	 * 
	 * @param val Le montant du débit souhaité
	 * @return Un booléen en fonction de la possibilité du débit
	 */
	public boolean peutDebiter(double val) {
		return (this.solde >= val);
	}
	
	
	/**
	 * Fonction permettant de créditer le solde d'un compte d'une valeur passée en paramètre
	 * 
	 * @param val Le montant à créditer
	 * 
	 * @throws OperationBancaireException Seulement pour les comptes rémunérés ( lors du dépassement
	 * du solde plafond )
	 */
	public void crediter(double val) throws OperationBancaireException {
		this.solde += val;
		this.historique.add(new Credit(Statut.OK, val));
	}
	
	/**
	 * Fonction crediter ayant comme parametre une opération
	 * 
	 * @param op L'opération concernée par le crédit
	 * 
	 * @return Un booléen en fonction du succès de l'opération
	 */
	public boolean crediter(Operation op) {
		this.solde += op.getMontant();
		op.modifierStatut(Statut.OK);
		this.historique.add(op);
		return true;
	}
	
	/**
	 * Fonction permettant de savoir si on peut crediter le compte ( pour CompteRemunere )
	 * 
	 * @param val La valeur du crédit
	 * @return Un booléen en fonction de la possibilité du crédit
	 */
	public boolean peutCrediter(double val)
	{
		return true;
	}
	
	
	/**
	 * Fonction toString
	 * 
	 * @return Un String affichant l'ID du compte, le libellé, le nom du titulaire et le solde actuel
	 */
	public String toString() {
		return "\nID du compte: " + this.numId +
				"\nLibellé: " + this.libelle +
				"\nTitulaire: " + this.titulaire.getNomClient() +
				"\nSolde actuel: " + this.solde +
				"\n\nHistorique des opérations: " + this.historique.toString() + "\n";
	}
	
	/**
	 * Fonction equals redéfinie pour Compte
	 * 
	 * @param obj Un Object à comparer ( utilisé avec un compte )
	 * @return Un booléen indiquant si les deux comptes sont identiques
	 */
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		if(this.numId == ((Compte)obj).numId) {
			return true;
		}
		return false;
	}
	
	/**
	 * Permet de récupérer le titulaire du compte
	 * 
	 * @return Le Client possédant le compte
	 */
	public Client getTitulaire() {
		return this.titulaire;
	}

}
