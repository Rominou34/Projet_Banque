package projetBanque;

import java.util.*;
import java.text.*;

/**
 * La classe pour les op�ration bancaires.
 * 
 * @author Romain
 *
 */
public class Operation {

	/**
	 * Le dernier id attribu�, permet d'�viter les doublons
	 */
	private static int lastId=0;
	
	/**
	 * L'id unique de l'op�ration, calcul� en fonction du lastId
	 */
	private int idOp;
	
	/**
	 * Le statut de l'op�ration ( OK, KO, ou ATTENTE )
	 */
	private Statut stat;
	
	/**
	 * Le montant de l'op�ration
	 */
	private double montant;
	
	/**
	 * La date de prise d'effet de l'op�ration, sous forme de String
	 */
	private String dateOp;
	
	
	/**
	 * Constructeur Operation, avec la nature, le statut et le montant de l'op�ration renseign�s
	 * 
	 * @param st Le statut de l'op�ration ( OK, KO ou ATTENTE )
	 * @param mont Le montant de l'op�ration
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
	 * @return Un String affichant l'id de l'op�ration, si c'est un d�bit / cr�dit, le montant
	 * et le statut ( Succ�s / Echec )
	 */
	public String toString() {
		return " Operation no " + this.idOp + ", Montant de " + this.montant + ", Statut: " + this.stat.toString()
					+ ", Date de prise d\'effet: " + this.dateOp;
	}
	
	/**
	 * Permet d'obtenir le montant de l'op�ration
	 * 
	 * @return Le montant de l'op�ration
	 */
	public double getMontant() {
		return this.montant;
	}
	
	/**
	 * Permet de modifier le statut de l'op�ration
	 * 
	 * @param stat Le nouveau statut � appliquer
	 */
	public void modifierStatut(Statut stat) {
		this.stat = stat;
	}

}
