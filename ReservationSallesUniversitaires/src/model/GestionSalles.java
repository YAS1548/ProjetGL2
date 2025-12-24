package model;

import java.util.*;
import observer.Observer;
import observer.Subject;
import strategy.PolitiqueReservationStrategy;
import strategy.PrioriteEnseignantStrategy;

public class GestionSalles implements Subject {

	private static GestionSalles instance;
	private List<Salle> salles = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();
	private PolitiqueReservationStrategy strategy;

	private GestionSalles() {
		this.strategy = new PrioriteEnseignantStrategy();
	}

	public static synchronized GestionSalles getInstance() {
		if (instance == null) {
			instance = new GestionSalles();
		}
		return instance;
	}

	@Override
	public void addObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver(String message) {
		for (Observer o : observers) {
			o.notifier(message);
		}
	}

	public void setStrategy(PolitiqueReservationStrategy strategy) {
		this.strategy = strategy;
	}

	public void ajouterSalle(Salle s) {
		salles.add(s);
		notifyObserver("Nouvelle salle ajoutée (ID : " + s.getNum() + ")");

	}

	public boolean reserverSalle(Reservation r) {
		if (strategy == null) {
			System.out.println("Warning: No reservation strategy defined.");
		}

		for (int i = 0; i < reservations.size(); i++) {
			Reservation existante = reservations.get(i);

			boolean sameSalle = r.getSalle().getNum() == existante.getSalle().getNum();
			boolean overlap = r.getHeure() < (existante.getHeure() + existante.getDuree())
					&& existante.getHeure() < (r.getHeure() + r.getDuree());

			if (sameSalle && overlap) {

				if (strategy != null && strategy.estPrioritaire(r.getUser(), existante.getUser())) {
					reservations.remove(i);
					reservations.add(r);
					existante.getUser().notifier("Votre réservation a été annulée (priorité supérieure)");
					r.getUser().notifier("Réservation acceptée (prioritaire)");
					return true;
				} else {

					r.getUser().notifier("Réservation refusée (conflit avec une réservation existante)");
					return false;
				}
			}
		}

		reservations.add(r);
		r.getUser().notifier("Réservation acceptée");
		return true;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public Salle trouverSalle(int num) {
		for (Salle s : salles) {
			if (s.getNum() == num)
				return s;
		}
		return null;
	}


	public void supprimerReservation(Reservation r) {
		reservations.remove(r);
	}

	public PolitiqueReservationStrategy getStrategy() {
		return strategy;
	}
}