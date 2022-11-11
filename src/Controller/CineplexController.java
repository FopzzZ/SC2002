package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;

public class CineplexController {
    private static ArrayList<Cineplex> cineplexList;
    private final static String dataBaseFilePath = "database/Cineplex.txt";

    public CineplexController() {
        cineplexList = new ArrayList<Cineplex>();
        File dbFile = new File(dataBaseFilePath);
        if (dbFile.exists())
            cineplexList = readFromDB();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Cineplex> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataBaseFilePath));
            ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) ois.readObject();
            ois.close();
            // System.out.println("Reading from cineplex database");
            return cineplexList;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e); // for testing
        }
        return new ArrayList<Cineplex>();
    }

    public void writeToDB(ArrayList<Cineplex> movielist) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataBaseFilePath));
            out.writeObject(cineplexList);
            out.flush();
            out.close();
            // System.out.println("Updating cineplex database");
        } catch (IOException e) {
            System.out.println(e); // for testing
        }
    }

    public void addNewCineplex(String name) { // insert types of 3 cinemas
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

    public boolean removeCineplex(Cineplex cineplex) {
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
        return found;
    }

    public void listCineplex() {
        for (int i = 0; i < cineplexList.size(); ++i) {
            System.out.printf("Cineplex %d: %s\n", i + 1, cineplexList.get(i).getName());
        }
        // System.out.printf("Total %d cineplexes.\n", cineplexList.size());
    }

    public ArrayList<Cineplex> getCineplexList() {
        return cineplexList;
    }

    public void listCinemas(Cineplex cineplex) {
        ArrayList<Cinema> cinemaList = cineplex.getCinemas();
        for (int i = 0; i < cinemaList.size(); ++i) {
            System.out.printf("%d: %s Type: %s\n", i + 1, cinemaList.get(i).getName(),
                    cinemaList.get(i).getType());
        }
        // System.out.printf("Total %d cinemas.\n", cinemaList.size());
    }

    public ArrayList<Cinema> getCinemaList(Cineplex cineplex) {
        return cineplex.getCinemas();
    }

    public void clearDatabase() {
        while (cineplexList.size() > 0) {
            cineplexList.remove(0);
        }
        writeToDB(cineplexList);
        // System.out.println("Clearing cineplex database");
    }

}
