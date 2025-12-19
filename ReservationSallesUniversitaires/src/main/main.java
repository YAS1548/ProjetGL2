package main;

import model.*;
import strategy.PrioriteEnseignantStrategy;
import controller.*;
import view.*;

public class main {

    public static void main(String[] args) {

        GestionSalles gestion = GestionSalles.getInstance();
        gestion.setStrategy(new PrioriteEnseignantStrategy());

        User user = new Enseignant(1, "User");

        ReservationController controller = new ReservationController();
        ConsoleView view = new ConsoleView(controller);
    	gestion.addObserver(user); 

        view.menu(user);
    }
}