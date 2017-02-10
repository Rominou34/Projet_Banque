package projetBanque;

/**
 * Les exceptions bancaires
 * 
 * @author Romain
 *
 */
public class OperationBancaireException extends Exception {

	/**
	 * Le message d'erreur à renvoyer dans le toString()
	 */
	private String str;
	
	/**
	 * Constructeur pour les exceptions des opérations bancaires.
	 * <p>Le solde et le montant de l'opération sont renseignés, et le constructeur détermine la
	 * cause de l'échec à partir de cela</p>
	 * @param solde Le solde du compte au moment de l'opération
	 * @param montant Le montant de l'opération
	 * @param op Le type d'opération ( true = débit, false = crédit )
	 */
	public OperationBancaireException(boolean op, double solde, double montant) {
		if(montant <= 0) {
			str = "Montant négatif ou nul: " + montant;
		}
		else {
			if(solde - montant <= 0 && op) {
				str = "Solde insuffisant, Solde: " + solde + ", Montant: " + montant;
			}
		}
	}
	
	/**
	 * Constructeur pour les exceptions des opérations bancaires lors d'un problème de solde plafond.
	 * <p>Le solde, le montant de l'opération et le solde plafond sont renseignés, et le constructeur détermine la
	 * cause de l'échec à partir de cela</p>
	 * @param solde Le solde du compte au moment de l'opération
	 * @param montant Le montant de l'opération
	 * @param soldeP Le solde plafond
	 * @param op Le type d'opération ( true = débit, false = crédit )
	 */
	public OperationBancaireException(boolean op, double solde, double montant, double soldeP) {
		if(montant <= 0) {
			str = "Montant négatif ou nul: " + montant;
		}
		else {
			if(solde - montant <= 0 && op) {
				str = "Solde insuffisant, Solde: " + solde + ", Montant: " + montant;
			}
			else {
				if(solde + montant > soldeP && !op) {
					str = "Dépassement du solde plafond. Solde après opération: " +
				(solde + montant) + ", Solde plafond: " + soldeP;
				}
			}
		}
	}
	
	/**
	 * Fonction toString()
	 * 
	 * @return Le message d'erreur correspondant à l'exception
	 */
	public String toString() {
		return this.str;
	}

}

