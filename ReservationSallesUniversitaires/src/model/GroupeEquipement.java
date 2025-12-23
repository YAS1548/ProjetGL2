package model;

import java.util.*;

public class GroupeEquipement extends Equipement {
	  
	
	 private List<Equipement> equipements = new ArrayList<>();

	   

	    public void ajouter(Equipement e) {
	        equipements.add(e);
	    }

	    public void retirer(Equipement e) {
	        equipements.remove(e);
	    }

	    @Override
	    public boolean estDisponible() {
	        for (Equipement e : equipements) {
	            if (!e.estDisponible()) return false;
	        }
	        return true;
	    }

	    @Override
	    public void afficher() {
	  
	    	  for (Equipement e : equipements) {
	              e.afficher();
	          }
	    }
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("Pack [");
	        for (int i = 0; i < equipements.size(); i++) {
	            sb.append(equipements.get(i).toString());
	            if (i < equipements.size() - 1) sb.append(", ");
	        }
	        sb.append("]");
	        return sb.toString();
	    }

}
