package model;

import java.util.ArrayList;
import java.util.List;

public class Salle {

	private int num;
	private int capacite;
	private String type;
	private Equipement equipement;
	

	public Salle(int num, int capacite, String type, Equipement equipement) {
		this.num = num;
		this.capacite = capacite;
		this.type = type;
		this.equipement = equipement;
	}


	

	public int getNum() {
		return num;
	}

	public int getCapacite() {
		return capacite;
	}

	public String getType() {
		return type;
	}
	public Equipement getEquipement() {
		return equipement;
		}
	

	 public boolean estDisponible() {
	        return equipement.estDisponible();
	    }

	    public void afficherEquipements() {
	        equipement.afficher();
	    }

}