package projetBanque;

/**
 * Les exceptions pour les ordres de virement
 * 
 * @author Romain
 *
 */
public class OrdreVirementException extends Exception {

	/**
	 * Le message d'erreur � afficher en fonction du probl�me rencontr�
	 */
	private String str;
	
	/**
	 * Constructeur pour les exceptions d'ordre de virement. Tous les attributs d'un ordre de
	 * virement sont pass�s en param�tre et le probl�me est d�termin� selon ces attributs.
	 * 
	 * @param donn Le client donneur d'ordre
	 * @param comO Le compte d'origine
	 * @param comD Le compte destinataire
	 * @param montant Le montant du virement
	 */
	public OrdreVirementException(Client donn, Compte comO, Compte comD, double montant) {
		str = "Erreur de d�tection du probl�me.";
		
		if( !comO.getTitulaire().equals(donn) ) {
			str = "Le compte d'origine n\'appartient pas au client donneur d'ordre.";
		}
		
		if( !comD.getTitulaire().equals(donn) ) {
			str = "Le compte destinataire n\'appartient pas au client donneur d'ordre.";
		}
		
		if(comO.solde < montant) {
			str = "Le solde du compte d'origine est insuffisant";
		}
	}
	
	/**
	 * Fonction toString(), renvyant le message d'erreur correspondant au probl�me ayant
	 * lev� l'exception
	 * 
	 * @return Un String correspondant au message d'erreur
	 */
	public String toString() {
		return this.str;
	}

}
