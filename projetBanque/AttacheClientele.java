package projetBanque;

import java.util.*;

/**
 * Les attach�s de client�le suivent les clients
 * <p>Un attach� de client�le suit plusieurs clients, mais les clients
 * ne sont suivis que par un seul attach� de client�le.
 * 
 * @author Romain
 *
 */
public class AttacheClientele {

	/**
	 * Le num�ro du dernier attach� de client�le, permettant d'�viter les doublons
	 * lors de la cr�ation d'un nouvel attach� de client�le
	 */
	private static int lastAttId=0;
	/**
	 * Le num�ro identifiant de l'attach� de client�le
	 */
	private int numeroAtt;
	
	/**
	 * Le nom de l'attach� client�le
	 */
	private String nomAttache;
	
	/**
	 * La liste des clients suivis par l'attach� de client�le
	 */
	private ArrayList<Client> listeClients;
	
	/**
	 * Constructeur pour l'attach� de client�le
	 * 
	 * <p>L'id de l'attach� de client�le est automatiquement calcul� en fonction du 
	 * lastAttId afin d'�viter les doublons </p>
	 * 
	 * <p>Lors de la cr�ation de l'attach� de client�le, on initie la liste des clients
	 * en tant que liste vide</p>
	 * 
	 * @param nom Le nom de l'attach� client�le
	 * 
	 * @see AttacheClientele#lastAttId
	 * @see AttacheClientele#numeroAtt
	 * @see AttacheClientele#listeClients
	 */
	public AttacheClientele(String nom) {
		this.numeroAtt = ++lastAttId;
		this.nomAttache = nom;
		this.listeClients = new ArrayList<Client>();
	}
	
	/**
	 * Fonction permettant de retourner l'id de l'attach� client�le
	 * 
	 * @return L'id de l'attach� client�le
	 */
	public int getAttacheId() {
		return this.numeroAtt;
	}
	
	/**
	 * Fonction permettant d'ajouter un client � la liste des clients de l'attach� client�le
	 * @param c Le client que l'on doit ajouter � la liste
	 */
	public void ajouterClient(Client c) {
		this.listeClients.add(c);
	}
	
	/**
	 * Fonction toString
	 */
	public String toString() {
		return "ID Attach� client�le: " + this.numeroAtt +
				"\nNom: " + this.nomAttache +
				"\nListe des clients: \n\n" + this.listeClients.toString();
	}
	
	/**
	 * Fonction permettant de forcer le d�bit sur un compte
	 * 
	 * @param com Le compte concern�
	 * @param op L'op�ration concern�e
	 */
	public void forcerDebit(Compte com, Operation op) {
		com.solde -= op.getMontant();
		op.modifierStatut(Statut.OK);
		com.historique.add(op);
	}
	
	/**
	 * Fonction permettant de forcer le cr�dit sur un compte
	 * 
	 * @param com Le compte concern�
	 * @param op L'op�ration concern�e
	 */
	public void forcerCredit(Compte com, Operation op) {
		com.solde += op.getMontant();
		op.modifierStatut(Statut.OK);
		com.historique.add(op);
	}

}
