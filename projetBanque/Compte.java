package projetBanque;

import java.util.*;

/**
 * La classe Compte permet de manipuler les comptes bancaires
 * <p>
 * Un compte bancaire peut �tre soit un compte courant, soit un compte
 * carte cr�dit, soit un compte r�mun�r�.
 * <p>
 * Tout compte b�n�ficie des caract�ristiques suivantes :
 * <ul><li>Poss�de un num�ro identifiant
 * <li>Poss�de un libell�
 * <li>Poss�de un solde
 * <li>Appartient � un client
 * </ul>
 * 
 * @author Romain
 *
 */
public class Compte {
	
	/**
	 * Le dernier id attribu�, permettant d'attribuer l'id du compte actuel
	 * en fonction de l'id du compte le plus r�cent. L'attribut est
	 * initialis� � 0
	 */
	private static int lastCompteId=0;
	
	/**
	 * Le num�ro identifiant du compte, non modifiable, attribu� lors de
	 * la cr�ation du compte.
	 */
	private int numId;
	
	/**
	 * Le libell� du compte
	 */
	private String libelle;
	
	/**
	 * Le solde du compte, consultable et modifiable lors des virements
	 * et autres op�rations bancaires. Accessible par toutes les classes du package
	 */
	double solde;
	
	/**
	 * Le client titulaire du compte
	 */
	private Client titulaire;

	/**
	 * L'historique des op�rations effectu�es sur le compte
	 */
	ArrayList<Operation> historique;
	
	
	/**
     * Constructeur du Compte
     * <p>L'id du compte est automatiquement calcul� en fonction du lastCompteId afin
     * d'�viter les doublons. A la fin on utilise la fonction ajouterCompte de la classe
     * Client afin d'ajouter le ocmpte � la liste des comptes du client</p>
     * 
     * @param lib Le libell� du compte
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
	 * Fonction permettant de d�biter le solde d'un compte d'une valeur pass�e en param�tre
	 * 
	 * @param val Le montant � d�biter
	 * 
	 * @throws OperationBancaireException Si le montant est n�gatif ou nul, ou si le solde est
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
	 * @param op L'op�ration concern�e par le d�bit
	 * 
	 * @return Un bool�en indiquant le succ�s ou l'�chec de l'op�ration
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
	 * Fonction permettant de savoir si un d�bit est possible
	 * 
	 * @param val Le montant du d�bit souhait�
	 * @return Un bool�en en fonction de la possibilit� du d�bit
	 */
	public boolean peutDebiter(double val) {
		return (this.solde >= val);
	}
	
	
	/**
	 * Fonction permettant de cr�diter le solde d'un compte d'une valeur pass�e en param�tre
	 * 
	 * @param val Le montant � cr�diter
	 * 
	 * @throws OperationBancaireException Seulement pour les comptes r�mun�r�s ( lors du d�passement
	 * du solde plafond )
	 */
	public void crediter(double val) throws OperationBancaireException {
		this.solde += val;
		this.historique.add(new Credit(Statut.OK, val));
	}
	
	/**
	 * Fonction crediter ayant comme parametre une op�ration
	 * 
	 * @param op L'op�ration concern�e par le cr�dit
	 * 
	 * @return Un bool�en en fonction du succ�s de l'op�ration
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
	 * @param val La valeur du cr�dit
	 * @return Un bool�en en fonction de la possibilit� du cr�dit
	 */
	public boolean peutCrediter(double val)
	{
		return true;
	}
	
	
	/**
	 * Fonction toString
	 * 
	 * @return Un String affichant l'ID du compte, le libell�, le nom du titulaire et le solde actuel
	 */
	public String toString() {
		return "\nID du compte: " + this.numId +
				"\nLibell�: " + this.libelle +
				"\nTitulaire: " + this.titulaire.getNomClient() +
				"\nSolde actuel: " + this.solde +
				"\n\nHistorique des op�rations: " + this.historique.toString() + "\n";
	}
	
	/**
	 * Fonction equals red�finie pour Compte
	 * 
	 * @param obj Un Object � comparer ( utilis� avec un compte )
	 * @return Un bool�en indiquant si les deux comptes sont identiques
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
	 * Permet de r�cup�rer le titulaire du compte
	 * 
	 * @return Le Client poss�dant le compte
	 */
	public Client getTitulaire() {
		return this.titulaire;
	}

}
