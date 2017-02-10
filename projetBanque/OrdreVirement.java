package projetBanque;

public class OrdreVirement {
	
	/**
	 * Constructeur de l'ordre de virement.
	 * <p>Le constructeur s'occupe de toute la gestion de l'ordre de virement, avec la v�rification
	 * de la possibilit� de d�bit, de cr�dit, ou de transfert � l'attach� client.
	 * <p>En cas d'erreur, une exception OrdreVirementException est g�n�r�d</p>
	 * 
	 * @param donn Le client donneur d'ordre
	 * @param comO Le compte d'origine
	 * @param comD Le compte destinataire
	 * @param mont Le montant du virement
	 * 
	 * @throws OrdreVirementException Si l'un des comptes n'appartient pas au client donneur d'ordre
	 * ou si le solde sur le compte d'origine est insuffisant
	 */
	public OrdreVirement(Client donn, Compte comO, Compte comD, double mont) throws OrdreVirementException {
		if(!comO.getTitulaire().equals(donn) || !comD.getTitulaire().equals(donn)) {
			throw new OrdreVirementException(donn, comO, comD, mont);
		}
		
		if(comO.peutDebiter(mont)) {
			Operation opCredit = new Credit(Statut.ATTENTE, mont);
			boolean succesOp = comD.crediter(opCredit);
			
			if(succesOp) {
				try {
					comO.debiter(mont);
				}
				catch (OperationBancaireException e) {}				
			}
			else {
				Operation debitAtt = new Debit(Statut.ATTENTE, mont);
				Operation creditAtt = new Credit(Statut.ATTENTE, mont);

				System.out.println("Virement de " + mont + " en attente de validation par l\'attach� client�le.");
				
				AttacheClientele attache = donn.getAttache();
				
				attache.forcerDebit(comO, debitAtt);
				attache.forcerCredit(comD, creditAtt);
			}
		}
		else {
			throw new OrdreVirementException(donn, comO, comD, mont);
		}
	}

}
