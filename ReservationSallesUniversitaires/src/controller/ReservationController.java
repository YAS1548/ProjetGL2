package controller;

import model.*;
import strategy.PrioriteClubStrategy;
import strategy.PrioriteEnseignantStrategy;
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

                boolean reservee = false;
                for (Reservation r : gestion.getReservations()) {
                    if (r.getSalle().getNum() == s.getNum()) {
                        reservee = true;
                        break;
                    }
                }

                view.afficherMessage(reservee ? "   ---------  Reservee  ---------" : "   ---------  Libre  ---------");

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
        
        view.afficherMessage("Minutes: ");
        int minutes = view.lireInt();

        view.afficherMessage("Duree (en minutes) : ");
        int duree = view.lireInt();

        Reservation r = new Reservation(new Date(), heure, minutes, duree, salle, user);



        boolean success = gestion.reserverSalle(r);
        if(success){
            view.afficherMessage("Reservation effectuee avec succes.");
        }else{
            view.afficherMessage("Impossible de reserver cette salle a cette heure.");
        }


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
                " | Minutes : " + r.getMinutes() +
                " | Duree (en minutes) : " + r.getDuree()
            );
        }
    }

    public void annulerReservation() {
        if (gestion.getReservations().isEmpty()) {
            view.afficherMessage("Aucune reservation a annuler.");
            return;
        }

        view.afficherMessage("Numero de la salle pour annuler La Reservation :");
        int numSalle = view.lireInt();
        Reservation r =null;

        for(Reservation res : gestion.getReservations()){
            if(res.getSalle().getNum()== numSalle){
                r = res;
                break;
            }
        }
        if(r!=null){
            gestion.supprimerReservation(r);
            view.afficherMessage("Reservation pour salle "+numSalle + " annule");
            r.getUser().notifier("Réservation Annule");
        }else{
            view.afficherMessage("Cette salle n'est pas reservee ou n'existe pas");
        }
    }


    public void PrioriteStrategy(){
        view.afficherMessage("Type de Priorite (1-Enseignant / 2-Club) : ");
        int typeUser = view.lireInt();
        if(typeUser==1){
            gestion.setStrategy(new PrioriteEnseignantStrategy());
            view.afficherMessage("Priorité définie : Enseignant");
        } else if (typeUser==2) {
            gestion.setStrategy(new PrioriteClubStrategy());
            view.afficherMessage("Priorité définie : Club");
        }else {
            view.afficherMessage("Choix invalide.");
        }

    }
}