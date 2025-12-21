package view;

import java.util.Scanner;

public class ConsoleView {

    private Scanner sc = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("\n===== SYSTEME DE RESERVATION DE SALLES =====");
        System.out.println("1. Ajouter une salle");
        System.out.println("2. Afficher les salles");
        System.out.println("3. Reserver une salle");
        System.out.println("4. Afficher les reservations");
        System.out.println("5. Annuler une reservation");
        System.out.println("6. Type de Priorite");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    public int lireInt() {
        return sc.nextInt();
    }

    public String lireString() {
        sc.nextLine(); // vider buffer
        return sc.nextLine();
    }

    public void afficherMessage(String msg) {
        System.out.println(msg);
    }
}