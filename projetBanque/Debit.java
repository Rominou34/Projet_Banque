package projetBanque;

/**
 * La classe pour les op�rations bancaires Debit, h�ritant de Operation
 * 
 * @author Romain
 *
 */
public class Debit extends Operation {

	/**
	 * Le constructeur Debit, h�ritant du constructeur Operation
	 * 
	 * @param st Le statut du d�bit
	 * @param mont Le montant du d�bit
	 * 
	 * @see Operation#Operation(Statut, double)
	 */
	public Debit(Statut st, double mont) {
		super(st,mont);
	}
	
	/**
	 * Le toString(), h�ritant du toString() de Operation
	 * 
	 * @return Une description du d�bit
	 * 
	 * @see Operation#toString()
	 */
	public String toString() {
		return "\nD�bit, " + super.toString();
	}

}
