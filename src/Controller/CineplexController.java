package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cinema.CinemaType;
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

    public void listCineplex() {
        for (int i = 0; i < cineplexList.size(); ++i) {
            System.out.printf("Cineplex %d: %s\n", i + 1, cineplexList.get(i).getName());
        }
        // System.out.printf("Total %d cineplexes.\n", cineplexList.size());
    }

    public ArrayList<Cineplex> getCineplexList() {
        return cineplexList;
    }

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

    public void changeCinemaType(Cineplex cineplex) {
        listCinemas(cineplex);
        System.out.print("Select cinema to change type: ");
        int selection = InputController.getIntFromUser(1, cineplex.getCinemas().size());
        CinemaType newType = CinemaType.NORMAL;
        System.out.printf("Current cinema type: %s\n", cineplex.getCinemas().get(selection - 1).getType());
        System.out.print("Select new cinema type: \n" +
                "1. Gold Class\n" +
                "2. Platinum\n" +
                "3. IMAX\n" +
                "4. Normal\n");
        switch (InputController.getIntFromUser(1, 4)) {
            case 1:
                newType = CinemaType.GOLDCLASS;
                break;
            case 2:
                newType = CinemaType.PLATINUM;
                break;
            case 3:
                newType = CinemaType.IMAX;
                break;
            case 4:
                newType = CinemaType.NORMAL;
                break;
        }
        int index = 0;
        boolean found = false;
        for (Cineplex c : cineplexList) {

            if (c.getName().equals(cineplex.getName())) {
                found = true;
                cineplexList.get(index).getCinemas().get(selection - 1).setType(newType);
                ;
            }
            index++;
        }
        if (!found) {
            System.out.println("Error no such cineplex found");
        }
        writeToDB(cineplexList);

    }

    public void listCinemas(Cineplex cineplex) {
        ArrayList<Cinema> cinemaList = cineplex.getCinemas();
        for (int i = 0; i < cinemaList.size(); ++i) {
            System.out.printf("%d: %s, Type: %s\n", i + 1, cinemaList.get(i).getName(),
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
        System.out.println("Clearing cineplex database");
    }

}
