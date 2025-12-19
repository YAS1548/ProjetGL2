package model;
import java.util.*;
import observer.Observer;
import observer.Subject;
import strategy.PolitiqueReservationStrategy;


public class GestionSalles implements Subject{
	
    private static GestionSalles instance;
    private List<Salle> salles = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private PolitiqueReservationStrategy strategy;


    private GestionSalles() {}
    
    public static GestionSalles getInstance() {
    	if(instance==null) {
    		instance=new GestionSalles();
    	}
    	return instance;
    }

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);	
	}

	@Override
	public void notifyObserver(String message) {
		for(Observer o :observers) {
			o.notifier(message);
		}
	}
	
	public void setStrategy(PolitiqueReservationStrategy strategy) {
		this.strategy=strategy;
	}
	
	public void ajouterSalle(Salle s) {
		salles.add(s);
	    notifyObserver("Nouvelle salle ajoutée (ID : " + s.getNum() + ")");

	}
	
	public void reserverSalle(Reservation r) {
		for(Reservation existante : reservations) {
			boolean memeSalle=r.getSalle().getNum()==existante.getSalle().getNum();
			boolean memeDate = r.getDate().equals(existante.getDate());
			boolean chevauchement =r.getHeure() < existante.getHeure() + existante.getDuree()
                                   && existante.getHeure() < r.getHeure() + r.getDuree(); 
			
			if(memeSalle && memeDate && chevauchement) {
				if(strategy.estPrioritaire(r.getUser(), existante.getUser())) {
					reservations.remove(existante);
					reservations.add(r);
					
					existante.getUser().notifier("Votre réservation a été annulée (priorité)");
					r.getUser().notifier("Réservation acceptée (prioritaire)");	
				}else {
					 r.getUser().notifier("Réservation refusée (conflit)");
				}
				return;
			}
		}
		reservations.add(r);
        r.getUser().notifier("Réservation acceptée");
        
	}
	
	public List<Salle> getSalles() {
	    return salles;
	}

	public List<Reservation> getReservations() {
	    return reservations;
	}

	public Salle trouverSalle(int num) {
	    for (Salle s : salles) {
	        if (s.getNum() == num) return s;
	    }
	    return null;
	}

	public void ajouterReservation(Reservation r) {
	    reservations.add(r);
	}

	public void supprimerReservation(Reservation r) {
	    reservations.remove(r);
	}


}