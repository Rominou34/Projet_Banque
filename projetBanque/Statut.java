package projetBanque;

/**
 * L'enum�ration pour le statut des op�rations bancaires
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
			return "Succ�s";
		case KO:
			return "Echec";
		case ATTENTE:
			return "En attente de validation";
		default:
			return "Statut invalide";
		}
	}
}
