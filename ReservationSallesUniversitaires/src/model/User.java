package model;

import observer.Observer;

public abstract class User implements Observer {

 protected int id;
 protected String nom;

public User(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

@Override
    public void notifier(String message) {
        System.out.println("Notification pour " + nom + " : " + message);
    }

}
