package model;
import java.util.Date;

public class Reservation {
	
	private Date date;
    private int heure;
    private int minutes;
    private int duree;
    private Salle salle;
    private User user;
    
    public Reservation(Date date, int heure,int minutes, int duree, Salle salle, User user) {
        this.date = date;
        this.heure = heure;
        this.minutes =minutes;
        this.duree = duree;
        this.salle = salle;
        this.user = user;
    }
    
    public Date getDate() { return date; }
    public int getHeure() { return heure; }
    public int getMinutes() { return minutes; }
    public int getDuree() { return duree; }
    public Salle getSalle() { return salle; }
    public User getUser() { return user; }
    
 
    

}