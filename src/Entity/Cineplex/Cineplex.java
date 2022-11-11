package Entity.Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cinema.CinemaType;
/**
* Cineplex is an entity containing cinemas
*/

public class Cineplex implements Serializable {
    private ArrayList<Cinema> cinemas;
    private String name;

    /**
    * A default constructor for the Cineplex Class with no name and 3 cinemas
    */
    public Cineplex() {
        cinemas = new ArrayList<Cinema>(3);
        name = "";
    }
    /**
    * A constructor for the Cineplex Class with custom name and number of cinemas
    * 
    * @param name Determines the name of the cineplex
    * @param cinemas Determines the cinemas assigned to the cineplex
    */
    public Cineplex(String name, ArrayList<Cinema> cinemas) {
        this.name = name;
        this.cinemas = cinemas;

    }

    
    /** 
     * @param name Determines the name of the Cineplex
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param cinemas Determines the cinemas assigned to the Cineplex
     */
    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    
    /** 
     * @return String This returns the name of the Cineplex
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @return ArrayList<Cinema> This returns an arraylist of cinemas in the cineplex
     */
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
