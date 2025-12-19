package controller;
import model.GestionSalles;
import model.Reservation;

public class ReservationController {
    private GestionSalles gestion;

    public ReservationController() {
    	this.gestion=GestionSalles.getInstance();
    }
    
    public void reserverSalle(Reservation r) {
        gestion.reserverSalle(r);
    }

    public void ajouterSalle(model.Salle s) {
        gestion.ajouterSalle(s);
    }
    
    public GestionSalles getGestion() {
        return gestion;
    }

}
