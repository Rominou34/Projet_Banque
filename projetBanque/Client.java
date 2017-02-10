package projetBanque;

import java.util.*;

/**
 * Les clients peuvent posséder plusieurs comptes bancaires, et ils sont suivis par un
 * attaché de clientèle.
 * <p>Tout client possède un numéro client et un nom</p>
 * 
 * @author Romain
 *
 */
public class Client {

	/**
	 * Le dernier numéro client attribué, nous permet d'attribuer les numéros aux clients
	 * par ordre croissant, en évitant les doublons ( on obtient Client 1, Client 2, Client 3... )
	 */
	private static int lastClientId=0;
	
	/**
	 * Le numéro client, permettant d'identifier le client lors des opérations bancaires
	 */
	private int numClient;
	
	/**
	 * Le nom du client
	 */
	private String nomClient;
	
	/**
	 * La liste de tous les comptes du client
	 */
	private ArrayList<Compte> listeComptes;
	
	/**
	 * L'attaché client suivant le client
	 */
	private AttacheClientele attache;
	
	
	
	/**
	 * Constructeur client sans attaché client
	 * 
	 * <p>On passe le nom du client et le numéro de son attaché client désigné en paramètre, le numéro 
	 * identifiant est calculé automatiquement à partir de lastClientId et la liste des comptes 
	 * est initialisée en tant que liste vide.</p>
	 * 
	 * @param nomC Le nom du client
	 * 
	 */
	public Client(String nomC) {
		this.numClient = ++lastClientId;
		this.nomClient = nomC;
		this.listeComptes = new ArrayList<Compte>();
		this.attache = null;
	}
	
	
	/**
	 * Constructeur client avec attaché client désigné
	 * 
	 * <p>On réutilise le constructeur client sans attaché client, et on utilise la fonction
	 * assignerAttache( AttacheClientele attache )</p>
	 * 
	 * @param nomC Le nom du client
	 * @param attC L'attaché clientèle
	 * 
	 * @see Client#Client(String)
	 * @see Client#assignerAttache(AttacheClientele)
	 * 
	 */
	public Client(String nomC, AttacheClientele attC) {
		this(nomC);
		this.assignerAttache(attC);
	}
	
	
	/**
	 * Fonction permettant d'ajouter un compte à la liste des comptes du client
	 * 
	 * @param com Le compte à ajouter
	 */
	public void ajouterCompte(Compte com) {
		listeComptes.add(com);
	}
	
	/**
	 * Fonction permettant d'assigner le client à un attaché client
	 * 
	 * @param attacheC L'attaché clientèle à qui on doit ajouter le client
	 */
	public void assignerAttache(AttacheClientele attacheC) {
		this.attache = attacheC;
		attacheC.ajouterClient(this);
	}
	
	/**
	 * Permet d'obtenir le nom du client
	 * 
	 * @return Un String contenant nom du client
	 */
	public String getNomClient() {
		return this.nomClient;
	}
	
	/**
	 * Fonction toString
	 */
	public String toString() {
		return "ID client: " + this.numClient +
				"\nNom: " + this.nomClient + 
				"\nID Attaché clientèle: " + attache.getAttacheId() + 
				"\nListe des comptes: \n\n" + this.listeComptes.toString();
	}
	
	/**
	 * Permet de récupérer l'attaché clientèle en charge du client
	 * 
	 * @return L'attaché clientèle étant en charge du client
	 */
	public AttacheClientele getAttache() {
		return this.attache;
	}
	
	/**
	 * Fonction equals redéfinie pour les clients
	 */
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		if (this.numClient == ((Client)obj).numClient) {
			return true;
		}
		return false;
	}

}
