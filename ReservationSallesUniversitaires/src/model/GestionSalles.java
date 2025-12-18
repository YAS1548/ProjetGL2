package model;

import java.util.*;

import observer.*;

public class GestionSalles implements Subject {

    private static GestionSalles instance;

    private List<Salle> salles = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private GestionSalles() {}

    public static GestionSalles getInstance() {
        if (instance == null) {
            instance = new GestionSalles();
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
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.notifier(message);
        }
    }

    public void ajouterSalle(Salle s) {
        salles.add(s);
    }
}
