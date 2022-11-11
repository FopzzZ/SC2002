package Entity.Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cinema.CinemaType;

public class Cineplex implements Serializable {
    private ArrayList<Cinema> cinemas;
    private String name;

    public Cineplex() {
        cinemas = new ArrayList<Cinema>(3);
        name = "";
    }

    public Cineplex(String name, ArrayList<Cinema> cinemas) {
        this.name = name;
        this.cinemas = cinemas;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    public void addCinema() {
        int cinemaNumber = getCinemas().size() + 1;
        String name = String.format("Cinema %d", cinemaNumber);
        Cinema newCinema = new Cinema(CinemaType.NORMAL, name);
        this.cinemas.add(newCinema);
    }

    // notice: if no such cinema in this cineplex, it will return null
    // public Cinema getCinemaByName(String name) {
    // for (Cinema cinema : cinemas) {
    // if (cinema.getName() == name)
    // return cinema;
    // }
    // return null;
    // }

}
