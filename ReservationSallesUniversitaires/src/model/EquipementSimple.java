package model;

public class EquipementSimple extends Equipement {
	
	private String nom;
    private boolean disponible;

    public EquipementSimple(String nom, boolean dispo) {
        this.nom = nom;
        this.disponible = dispo;
    }

    @Override
    public boolean estDisponible() {
        return disponible;
    }

    @Override
    public void afficher() {
        System.out.println("-" + nom);
    }
}