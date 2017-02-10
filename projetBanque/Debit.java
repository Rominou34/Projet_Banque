package projetBanque;

/**
 * La classe pour les opérations bancaires Debit, héritant de Operation
 * 
 * @author Romain
 *
 */
public class Debit extends Operation {

	/**
	 * Le constructeur Debit, héritant du constructeur Operation
	 * 
	 * @param st Le statut du débit
	 * @param mont Le montant du débit
	 * 
	 * @see Operation#Operation(Statut, double)
	 */
	public Debit(Statut st, double mont) {
		super(st,mont);
	}
	
	/**
	 * Le toString(), héritant du toString() de Operation
	 * 
	 * @return Une description du débit
	 * 
	 * @see Operation#toString()
	 */
	public String toString() {
		return "\nDébit, " + super.toString();
	}

}
