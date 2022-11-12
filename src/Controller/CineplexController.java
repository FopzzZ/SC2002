package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cinema.CinemaType;
import Entity.Cineplex.Cineplex;

/**
 * Controller to access and edit database containing cineplex and cinema info
 */
public class CineplexController {
    private static ArrayList<Cineplex> cineplexList;
    private final static String dataBaseFilePath = "database/Cineplex.txt";

    /**
     * Class constructor
     */
    public CineplexController() {
        cineplexList = new ArrayList<Cineplex>();
        File dbFile = new File(dataBaseFilePath);
        if (dbFile.exists())
            cineplexList = readFromDB();
    }

    /**
     * Read from database
     * 
     * @return ArrayList<Cineplex> list of cineplex objects currently in database
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Cineplex> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataBaseFilePath));
            ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) ois.readObject();
            ois.close();
            return cineplexList;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
        return new ArrayList<Cineplex>();
    }

    /**
     * Write to database
     * 
     * @param cineplexList current list of cineplex objects
     */
    public void writeToDB(ArrayList<Cineplex> cineplexList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataBaseFilePath));
            out.writeObject(cineplexList);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Add new cineplex with default 3 cinemas
     * 
     * @param name name of new cineplex
     */
    public void addNewCineplex(String name) { // add 3 cinemas of nomal types
        Cinema cinema1 = new Cinema("Cinema 1");
        Cinema cinema2 = new Cinema("Cinema 2");
        Cinema cinema3 = new Cinema("Cinema 3");
        ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
        cinemaList.add(cinema1);
        cinemaList.add(cinema2);
        cinemaList.add(cinema3);
        Cineplex newCineplex = new Cineplex(name, cinemaList);
        cineplexList.add(newCineplex);
        writeToDB(cineplexList);
    }

    /**
     * Remove a cineplex from database
     * 
     * @param cineplex cineplex to be removed
     */
    public void removeCineplex(Cineplex cineplex) {
        int index = 0;
        boolean found = false;
        for (Cineplex c : cineplexList) {
            if (c.getName().equals(cineplex.getName())) {
                cineplexList.remove(index);
                found = true;
                break;
            }
            index++;
        }
        if (!found) {
            System.out.println("No such cinema");
        }
        writeToDB(cineplexList);
    }

    /**
     * Print current list of cineplexes
     */
    public void listCineplex() {
        System.out.println("\n" +
                "--------------\n" +
                "| Cineplexes |\n" +
                "--------------");
        for (int i = 0; i < cineplexList.size(); ++i) {
            System.out.printf("Cineplex %d: %s\n", i + 1, cineplexList.get(i).getName());
        }
    }

    /**
     * Get current list of cineplexes
     * 
     * @return ArrayList<Cineplex> current list of cineplexes
     */
    public ArrayList<Cineplex> getCineplexList() {
        return cineplexList;
    }

    /**
     * Add a cinema to a cineplex
     * 
     * @param cineplex cineplex to add a cinema to
     */
    public void addCinema(Cineplex cineplex) {
        boolean found = false;
        int index = 0;
        for (Cineplex c : cineplexList) {

            if (c.getName().equals(cineplex.getName())) {
                found = true;
                cineplexList.get(index).addCinema();
            }
            index++;
        }
        if (!found) {
            System.out.println("Error no such cineplex found");
        }
        // add to cineplex
        writeToDB(cineplexList);
    }

    /**
     * Change cinema type of a specific cineplex and cinema
     * 
     * @param cineplex    cineplex that contains the cinema to be changed
     * @param cinemaIndex cinema index number
     * @param newType     new type of the cinema
     */
    public void changeCinemaType(Cineplex cineplex, int cinemaIndex, CinemaType newType) {

        int index = 0;
        boolean found = false;
        for (Cineplex c : cineplexList) {

            if (c.getName().equals(cineplex.getName())) {
                found = true;
                cineplexList.get(index).getCinemas().get(cinemaIndex).setType(newType);
                ;
            }
            index++;
        }
        if (!found) {
            System.out.println("Error no such cineplex found");
        }
        writeToDB(cineplexList);

    }

    /**
     * Print list of cinemas of a certain cineplex
     * 
     * @param cineplex cineplex to print list of cinemas
     */
    public void listCinemas(Cineplex cineplex) {
        System.out.println("\n" +
                "-----------\n" +
                "| Cinemas |\n" +
                "-----------");
        ArrayList<Cinema> cinemaList = cineplex.getCinemas();
        for (int i = 0; i < cinemaList.size(); ++i) {
            System.out.printf("%d: %s, Type: %s\n", i + 1, cinemaList.get(i).getName(),
                    cinemaList.get(i).getType());
        }
    }

    /**
     * Get list of cinemas in a specific cineplex
     * 
     * @param cineplex cineplex to retrieve list of cinemas from
     * @return ArrayList<Cinema> list of cinemas in the cineplex
     */
    public ArrayList<Cinema> getCinemaList(Cineplex cineplex) {
        return cineplex.getCinemas();
    }

    public void clearDatabase() {
        while (cineplexList.size() > 0) {
            cineplexList.remove(0);
        }
        writeToDB(cineplexList);
        System.out.println("Clearing cineplex database");
    }

}
