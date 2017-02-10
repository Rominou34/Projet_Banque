package projetBanque;

import java.util.*;

/**
 * Les clients peuvent poss�der plusieurs comptes bancaires, et ils sont suivis par un
 * attach� de client�le.
 * <p>Tout client poss�de un num�ro client et un nom</p>
 * 
 * @author Romain
 *
 */
public class Client {

	/**
	 * Le dernier num�ro client attribu�, nous permet d'attribuer les num�ros aux clients
	 * par ordre croissant, en �vitant les doublons ( on obtient Client 1, Client 2, Client 3... )
	 */
	private static int lastClientId=0;
	
	/**
	 * Le num�ro client, permettant d'identifier le client lors des op�rations bancaires
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
	 * L'attach� client suivant le client
	 */
	private AttacheClientele attache;
	
	
	
	/**
	 * Constructeur client sans attach� client
	 * 
	 * <p>On passe le nom du client et le num�ro de son attach� client d�sign� en param�tre, le num�ro 
	 * identifiant est calcul� automatiquement � partir de lastClientId et la liste des comptes 
	 * est initialis�e en tant que liste vide.</p>
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
	 * Constructeur client avec attach� client d�sign�
	 * 
	 * <p>On r�utilise le constructeur client sans attach� client, et on utilise la fonction
	 * assignerAttache( AttacheClientele attache )</p>
	 * 
	 * @param nomC Le nom du client
	 * @param attC L'attach� client�le
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
	 * Fonction permettant d'ajouter un compte � la liste des comptes du client
	 * 
	 * @param com Le compte � ajouter
	 */
	public void ajouterCompte(Compte com) {
		listeComptes.add(com);
	}
	
	/**
	 * Fonction permettant d'assigner le client � un attach� client
	 * 
	 * @param attacheC L'attach� client�le � qui on doit ajouter le client
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
				"\nID Attach� client�le: " + attache.getAttacheId() + 
				"\nListe des comptes: \n\n" + this.listeComptes.toString();
	}
	
	/**
	 * Permet de r�cup�rer l'attach� client�le en charge du client
	 * 
	 * @return L'attach� client�le �tant en charge du client
	 */
	public AttacheClientele getAttache() {
		return this.attache;
	}
	
	/**
	 * Fonction equals red�finie pour les clients
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
