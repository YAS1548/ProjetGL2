package controller;

import model.*;
import view.ConsoleView;

import java.util.Date;

public class ReservationController {

    private GestionSalles gestion = GestionSalles.getInstance();
    private ConsoleView view;

    public ReservationController(ConsoleView view) {
        this.view = view;
    }

    public void ajouterSalle() {
        view.afficherMessage("Numero de la salle : ");
        int num = view.lireInt();

        view.afficherMessage("Capacite : ");
        int capacite = view.lireInt();

        view.afficherMessage("Type (TD / TP / Amphi) : ");
        String type = view.lireString();

        Salle salle = new Salle(num, capacite, type);
        gestion.ajouterSalle(salle);

        view.afficherMessage("Salle ajoutee avec succes.");
    }

    public void afficherSalles() {
        if (gestion.getSalles().isEmpty()) {
            view.afficherMessage("Aucune salle disponible.");
            return;
        }

        for (Salle s : gestion.getSalles()) {
            view.afficherMessage(
                "Salle " + s.getNum() +
                " | Capacite : " + s.getCapacite() +
                " | Type : " + s.getType()
            );
        }
    }

    public void reserverSalle() {
        if (gestion.getSalles().isEmpty()) {
            view.afficherMessage("Aucune salle disponible.");
            return;
        }

        view.afficherMessage("Type utilisateur (1-Enseignant / 2-Club) : ");
        int typeUser = view.lireInt();

        view.afficherMessage("Nom : ");
        String nom = view.lireString();

        User user;
        if (typeUser == 1) {
            user = new Enseignant(1, nom);
        } else {
            user = new Club(2, nom);
        }

        gestion.addObserver(user);

        view.afficherMessage("Numero de la salle : ");
        int numSalle = view.lireInt();

        Salle salle = gestion.trouverSalle(numSalle);
        if (salle == null) {
            view.afficherMessage("Salle introuvable.");
            return;
        }

        view.afficherMessage("Heure de debut : ");
        int heure = view.lireInt();

        view.afficherMessage("Duree (en heures) : ");
        int duree = view.lireInt();

        Reservation r = new Reservation(new Date(), heure, duree, salle, user);
        gestion.ajouterReservation(r);

        gestion.notifyObserver("Reservation effectuee avec succes.");
    }

    public void afficherReservations() {
        if (gestion.getReservations().isEmpty()) {
            view.afficherMessage("Aucune reservation.");
            return;
        }

        for (Reservation r : gestion.getReservations()) {
            view.afficherMessage(
                "Salle " + r.getSalle().getNum() +
                " | Utilisateur : " + r.getUser().getNom() +
                " | Heure : " + r.getHeure() +
                " | Duree : " + r.getDuree()
            );
        }
    }

    public void annulerReservation() {
        if (gestion.getReservations().isEmpty()) {
            view.afficherMessage("Aucune reservation a annuler.");
            return;
        }

        Reservation r = gestion.getReservations().get(0);
        gestion.supprimerReservation(r);
        gestion.notifyObserver("Reservation annulee.");
    }
}
