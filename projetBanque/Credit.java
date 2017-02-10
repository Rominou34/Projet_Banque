package projetBanque;

/**
 * La clasee pour les op�rations bancaires cr�dit, h�ritant de Credit
 * 
 * @author Romain
 *
 */
public class Credit extends Operation {

	/**
	 * Le constructeur Credit, h�ritant du constructeur Operation
	 * 
	 * @param st Le statut du cr�dit
	 * @param mont Le montant du cr�dit
	 * 
	 * @see Operation#Operation(Statut, double)
	 */
	public Credit(Statut st, double mont) {
		super(st, mont);
	}
	
	/**
	 * Le toString(), h�ritant du toString() de Operation
	 * 
	 * @return Une description du cr�dit
	 * 
	 * @see Operation#toString()
	 */
	public String toString() {
		return "\nCr�dit, " + super.toString();
	}

}
