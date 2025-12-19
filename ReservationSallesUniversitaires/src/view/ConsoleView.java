package view;

import java.util.*;
import controller.*;
import model.*;

public class ConsoleView {

    private ReservationController controller;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleView(ReservationController controller) {
        this.controller = controller;
    }

    public void menu(User user) {

        System.out.println("1. Ajouter salle");
        System.out.println("2. Réserver salle");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            ajouterSalle();
        } else if (choix == 2) {
            reserverSalle(user);
        }
    }

    private void ajouterSalle() {
        System.out.print("ID : ");
        int id = scanner.nextInt();

        System.out.print("Capacité : ");
        int cap = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type : ");
        String type = scanner.nextLine();

        controller.ajouterSalle(new Salle(id, cap, type));

    }

    private void reserverSalle(User user) {
        System.out.print("ID salle : ");
        int idSalle = scanner.nextInt();

        System.out.print("Heure : ");
        int heure = scanner.nextInt();

        System.out.print("Durée : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        Reservation r = new Reservation(new Date(), heure, duree,
                new Salle(idSalle, 0, ""), user);

        controller.reserverSalle(r);
    }
}
