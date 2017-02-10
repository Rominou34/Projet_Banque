package projetBanque;

/**
 * Les exceptions pour les ordres de virement
 * 
 * @author Romain
 *
 */
public class OrdreVirementException extends Exception {

	/**
	 * Le message d'erreur à afficher en fonction du problème rencontré
	 */
	private String str;
	
	/**
	 * Constructeur pour les exceptions d'ordre de virement. Tous les attributs d'un ordre de
	 * virement sont passés en paramètre et le problème est déterminé selon ces attributs.
	 * 
	 * @param donn Le client donneur d'ordre
	 * @param comO Le compte d'origine
	 * @param comD Le compte destinataire
	 * @param montant Le montant du virement
	 */
	public OrdreVirementException(Client donn, Compte comO, Compte comD, double montant) {
		str = "Erreur de détection du problème.";
		
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
	 * Fonction toString(), renvyant le message d'erreur correspondant au problème ayant
	 * levé l'exception
	 * 
	 * @return Un String correspondant au message d'erreur
	 */
	public String toString() {
		return this.str;
	}

}
