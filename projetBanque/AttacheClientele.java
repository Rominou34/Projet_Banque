package projetBanque;

import java.util.*;

/**
 * Les attachés de clientèle suivent les clients
 * <p>Un attaché de clientèle suit plusieurs clients, mais les clients
 * ne sont suivis que par un seul attaché de clientèle.
 * 
 * @author Romain
 *
 */
public class AttacheClientele {

	/**
	 * Le numéro du dernier attaché de clientèle, permettant d'éviter les doublons
	 * lors de la création d'un nouvel attaché de clientèle
	 */
	private static int lastAttId=0;
	/**
	 * Le numéro identifiant de l'attaché de clientèle
	 */
	private int numeroAtt;
	
	/**
	 * Le nom de l'attaché clientèle
	 */
	private String nomAttache;
	
	/**
	 * La liste des clients suivis par l'attaché de clientèle
	 */
	private ArrayList<Client> listeClients;
	
	/**
	 * Constructeur pour l'attaché de clientèle
	 * 
	 * <p>L'id de l'attaché de clientèle est automatiquement calculé en fonction du 
	 * lastAttId afin d'éviter les doublons </p>
	 * 
	 * <p>Lors de la création de l'attaché de clientèle, on initie la liste des clients
	 * en tant que liste vide</p>
	 * 
	 * @param nom Le nom de l'attaché clientèle
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
	 * Fonction permettant de retourner l'id de l'attaché clientèle
	 * 
	 * @return L'id de l'attaché clientèle
	 */
	public int getAttacheId() {
		return this.numeroAtt;
	}
	
	/**
	 * Fonction permettant d'ajouter un client à la liste des clients de l'attaché clientèle
	 * @param c Le client que l'on doit ajouter à la liste
	 */
	public void ajouterClient(Client c) {
		this.listeClients.add(c);
	}
	
	/**
	 * Fonction toString
	 */
	public String toString() {
		return "ID Attaché clientèle: " + this.numeroAtt +
				"\nNom: " + this.nomAttache +
				"\nListe des clients: \n\n" + this.listeClients.toString();
	}
	
	/**
	 * Fonction permettant de forcer le débit sur un compte
	 * 
	 * @param com Le compte concerné
	 * @param op L'opération concernée
	 */
	public void forcerDebit(Compte com, Operation op) {
		com.solde -= op.getMontant();
		op.modifierStatut(Statut.OK);
		com.historique.add(op);
	}
	
	/**
	 * Fonction permettant de forcer le crédit sur un compte
	 * 
	 * @param com Le compte concerné
	 * @param op L'opération concernée
	 */
	public void forcerCredit(Compte com, Operation op) {
		com.solde += op.getMontant();
		op.modifierStatut(Statut.OK);
		com.historique.add(op);
	}

}
