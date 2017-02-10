package projetBanque;

/**
 * Les exceptions bancaires
 * 
 * @author Romain
 *
 */
public class OperationBancaireException extends Exception {

	/**
	 * Le message d'erreur � renvoyer dans le toString()
	 */
	private String str;
	
	/**
	 * Constructeur pour les exceptions des op�rations bancaires.
	 * <p>Le solde et le montant de l'op�ration sont renseign�s, et le constructeur d�termine la
	 * cause de l'�chec � partir de cela</p>
	 * @param solde Le solde du compte au moment de l'op�ration
	 * @param montant Le montant de l'op�ration
	 * @param op Le type d'op�ration ( true = d�bit, false = cr�dit )
	 */
	public OperationBancaireException(boolean op, double solde, double montant) {
		if(montant <= 0) {
			str = "Montant n�gatif ou nul: " + montant;
		}
		else {
			if(solde - montant <= 0 && op) {
				str = "Solde insuffisant, Solde: " + solde + ", Montant: " + montant;
			}
		}
	}
	
	/**
	 * Constructeur pour les exceptions des op�rations bancaires lors d'un probl�me de solde plafond.
	 * <p>Le solde, le montant de l'op�ration et le solde plafond sont renseign�s, et le constructeur d�termine la
	 * cause de l'�chec � partir de cela</p>
	 * @param solde Le solde du compte au moment de l'op�ration
	 * @param montant Le montant de l'op�ration
	 * @param soldeP Le solde plafond
	 * @param op Le type d'op�ration ( true = d�bit, false = cr�dit )
	 */
	public OperationBancaireException(boolean op, double solde, double montant, double soldeP) {
		if(montant <= 0) {
			str = "Montant n�gatif ou nul: " + montant;
		}
		else {
			if(solde - montant <= 0 && op) {
				str = "Solde insuffisant, Solde: " + solde + ", Montant: " + montant;
			}
			else {
				if(solde + montant > soldeP && !op) {
					str = "D�passement du solde plafond. Solde apr�s op�ration: " +
				(solde + montant) + ", Solde plafond: " + soldeP;
				}
			}
		}
	}
	
	/**
	 * Fonction toString()
	 * 
	 * @return Le message d'erreur correspondant � l'exception
	 */
	public String toString() {
		return this.str;
	}

}

