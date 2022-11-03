package Entity.Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.Cinema.Cinema;

public class Cineplex implements Serializable {
    private ArrayList<Cinema> cinemas;
    private String name;
    private int ID;

    public Cineplex() {
        cinemas = new ArrayList<Cinema>();
        name = "";
        ID = -1;
    }

    public Cineplex(String name, ArrayList<Cinema> cinemas,int ID) {
        this.name = name;
        this.cinemas = cinemas;
        this.ID = ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    //notice: if no such cinema in this cineplex, it will return null
    public Cinema getCinemaByName(String name) {
        for(Cinema cinema: cinemas) {
            if(cinema.getName() == name) 
                return cinema;
        }
        return null;
    }

}
