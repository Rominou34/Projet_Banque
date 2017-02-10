package projetBanque;

/**
 * La clasee pour les opérations bancaires crédit, héritant de Credit
 * 
 * @author Romain
 *
 */
public class Credit extends Operation {

	/**
	 * Le constructeur Credit, héritant du constructeur Operation
	 * 
	 * @param st Le statut du crédit
	 * @param mont Le montant du crédit
	 * 
	 * @see Operation#Operation(Statut, double)
	 */
	public Credit(Statut st, double mont) {
		super(st, mont);
	}
	
	/**
	 * Le toString(), héritant du toString() de Operation
	 * 
	 * @return Une description du crédit
	 * 
	 * @see Operation#toString()
	 */
	public String toString() {
		return "\nCrédit, " + super.toString();
	}

}
