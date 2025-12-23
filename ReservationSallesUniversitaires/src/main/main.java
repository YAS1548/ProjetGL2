package main;

import controller.*;
import view.*;

public class main {

	public static void main(String[] args) {

		ConsoleView view = new ConsoleView();
		ReservationController controller = new ReservationController(view);

		int choix;
		do {
			view.afficherMenu();
			choix = view.lireInt();

			switch (choix) {
			case 1:
				controller.ajouterSalle();
				break;
			case 2:
				controller.afficherSalles();
				break;
			case 3:
				controller.reserverSalle();
				break;
			case 4:
				controller.afficherReservations();
				break;
			case 5:
				controller.annulerReservation();
				break;
			case 6:
				controller.PrioriteStrategy();
				break;
			case 0:
				view.afficherMessage("Au revoir !!!!!");
				break;
			default:
				view.afficherMessage("Choix invalide!!!");
			}
		} while (choix != 0);
	}
}