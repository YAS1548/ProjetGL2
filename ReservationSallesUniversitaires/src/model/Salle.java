package model;
import java.util.ArrayList;
import java.util.List;

public class Salle {
	private int num;
    private int capacite;
     private String type;
	 private List<Equipement> equipements = new ArrayList<>();
  
	 
public Salle(int num, int capacite, String type) {
	this.num = num;
	this.capacite = capacite;
	this.type = type;
}

	    public void ajouterEquipement(Equipement e) {
	        equipements.add(e);
	    }

}
