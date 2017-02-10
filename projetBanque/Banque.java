package projetBanque;

/**
 * <b>Banque est la classe éxécutable contenant le programme
 * principal</b>
 * 
 * @author Romain
 *
 */
public class Banque {

	public static void main(String[] args) {
		
		AttacheClientele attache1 = new AttacheClientele("Attache Clientele no1");
		AttacheClientele attache2 = new AttacheClientele("Attache Clientele no2");
		
		Client c = new Client("Client C", attache1);
		Client c2 = new Client("Client C2", attache2);
		
		Compte compteCourant1 = new CompteCourant("Compte courant no1", c);
		Compte compteEpargne1 = new CompteEpargne("Compte epargne no1", c, 50, 700);
		Compte compteCC = new CarteCredit("Carte de credit no1", c2);
		
		try {
			compteCourant1.crediter(2000);
		}
		catch (OperationBancaireException e) {
			System.out.println(e.toString());
		}
		
		try {
			compteEpargne1.crediter(33);
		}
		catch (OperationBancaireException e) {
			System.out.println(e.toString());
		}
		
		try {
			compteCourant1.debiter(500);
		}
		catch (OperationBancaireException e) {
			System.out.println(e.toString());
		}
		
		try {
			compteCourant1.debiter(2500);
		}
		catch (OperationBancaireException e) {
			System.out.println(e.toString());
		}
		
		OrdreVirement ov1 = null;
		OrdreVirement ov2 = null;
		OrdreVirement ov3 = null;
		
		compteCourant1.debiter(new Debit(Statut.ATTENTE, 123));
		compteCourant1.crediter(new Credit(Statut.ATTENTE, 1.55));
		
		try {
			ov1 = new OrdreVirement(c, compteCourant1, compteEpargne1, 666);
		}
		catch (OrdreVirementException e) {
			System.out.println(e.toString());
		}
		
		try {
			ov2 = new OrdreVirement(c, compteCourant1, compteEpargne1, 10000);
		}
		catch (OrdreVirementException e) {
			System.out.println(e.toString());
		}
		
		try {
			ov3 = new OrdreVirement(c, compteCourant1, compteEpargne1, 10);
		}
		catch (OrdreVirementException e) {
			System.out.println(e.toString());
		}
		
		
		System.out.println("\n-----\n\n" + c.toString());
		System.out.println("\n-----\n\n" + c2.toString());
	}

}
