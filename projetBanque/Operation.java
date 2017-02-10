package projetBanque;

import java.util.*;
import java.text.*;

/**
 * La classe pour les opération bancaires.
 * 
 * @author Romain
 *
 */
public class Operation {

	/**
	 * Le dernier id attribué, permet d'éviter les doublons
	 */
	private static int lastId=0;
	
	/**
	 * L'id unique de l'opération, calculé en fonction du lastId
	 */
	private int idOp;
	
	/**
	 * Le statut de l'opération ( OK, KO, ou ATTENTE )
	 */
	private Statut stat;
	
	/**
	 * Le montant de l'opération
	 */
	private double montant;
	
	/**
	 * La date de prise d'effet de l'opération, sous forme de String
	 */
	private String dateOp;
	
	
	/**
	 * Constructeur Operation, avec la nature, le statut et le montant de l'opération renseignés
	 * 
	 * @param st Le statut de l'opération ( OK, KO ou ATTENTE )
	 * @param mont Le montant de l'opération
	 */
	public Operation(Statut st, double mont) {
		this.idOp = ++lastId;
		this.stat = st;
		this.montant = mont;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.dateOp = format.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * Fonction toStrig()
	 * 
	 * @return Un String affichant l'id de l'opération, si c'est un débit / crédit, le montant
	 * et le statut ( Succès / Echec )
	 */
	public String toString() {
		return " Operation no " + this.idOp + ", Montant de " + this.montant + ", Statut: " + this.stat.toString()
					+ ", Date de prise d\'effet: " + this.dateOp;
	}
	
	/**
	 * Permet d'obtenir le montant de l'opération
	 * 
	 * @return Le montant de l'opération
	 */
	public double getMontant() {
		return this.montant;
	}
	
	/**
	 * Permet de modifier le statut de l'opération
	 * 
	 * @param stat Le nouveau statut à appliquer
	 */
	public void modifierStatut(Statut stat) {
		this.stat = stat;
	}

}
