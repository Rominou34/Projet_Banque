package projetBanque;

/**
 * L'enumération pour le statut des opérations bancaires
 * 
 * @author Romain
 *
 */
public enum Statut {
	OK,
	KO,
	ATTENTE;
	
	public String toString() {
		switch(this)
		{
		case OK:
			return "Succès";
		case KO:
			return "Echec";
		case ATTENTE:
			return "En attente de validation";
		default:
			return "Statut invalide";
		}
	}
}
