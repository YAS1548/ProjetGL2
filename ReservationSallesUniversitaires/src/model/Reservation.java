package model;
import java.util.Date;

public class Reservation {

 private Date date;
 private int heure;
 private int duree;
 private Salle salle;
 private User utilisateur;
 
 public Reservation(Date date, int heure, int duree, Salle salle, User utilisateur) {
     this.date = date;
     this.heure = heure;
     this.duree = duree;
     this.salle = salle;
     this.utilisateur = utilisateur;
 }
 
}
