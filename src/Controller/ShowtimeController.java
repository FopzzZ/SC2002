package Controller;

import java.io.*;
import java.util.ArrayList;

import Entity.Cinema.Cinema;
import Entity.Cineplex.Cineplex;
import Entity.Movie.Movie;
import Entity.Showtime.*;

public class ShowtimeController {

    private ArrayList<Showtime> showtimeList;

    private final static String DataBaseFilePath = "DataBase/Showtimes.txt";

    public ShowtimeController() {
        showtimeList = new ArrayList<Showtime>();
        File dbFile = new File(DataBaseFilePath);
        if(dbFile.exists())
            showtimeList = readFromDB();
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Showtime> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBaseFilePath));   
            ArrayList<Showtime> ShowtimeListing = (ArrayList<Showtime>) ois.readObject();
            ois.close();
            return ShowtimeListing;
        } catch (ClassNotFoundException | IOException e) {
        } 
        return new ArrayList<Showtime>();
    }

    public void writeToDB(ArrayList<Showtime> Showtimelist) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DataBaseFilePath));
            out.writeObject(Showtimelist);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    }

    private int getLastID() {
        return showtimeList.get(showtimeList.size() - 1).getID();
    }

    public void create(Movie movie, Time time, Cineplex cineplex, Cinema cinema, boolean isHoliday) {
        Showtime showtime = new Showtime(getLastID() + 1, movie, time, cineplex, cinema, isHoliday);
        showtimeList.add(showtime);
        writeToDB(showtimeList);
    }

    //return the index in ArrayList
    public int searchWithID(int ID) {
        for (int i = 0; i < showtimeList.size(); ++i) {
            if (showtimeList.get(i).getID() == ID)
                return i;
        }
        return -1;
    }

    
    //Return false if no such showtime; Otherwise true
    public boolean removeWithID(int ID) {
        int index = searchWithID(ID);
        if(index == -1){
            return false;
        } 
        remove(index);
        return true;
    }

    public void remove(int index) {
        this.showtimeList.remove(index);
    }
}
