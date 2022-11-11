package Controller;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Entity.Cinema.CinemaType;
import Entity.Movie.Movie;
import Entity.Movie.MovieType;
import Entity.Showtime.Showtime;
import Entity.User.AgeClass;
import Entity.User.User;

public class BookingController {
    double goldclassSurcharge, platinumSurcharge, imaxSurcharge, blockbusterSurcharge,
            threedSurcharge, childDiscount,
            seniorCitizenDiscount, weekendSurcharge, holidaySurcharge, defaultTicketPrice;

    private final static String DataBaseFilePath = "DataBase/Surcharges.txt";
    private static ArrayList<Double> surchargeList;

    public BookingController() {
        surchargeList = new ArrayList<Double>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            surchargeList = readFromDB();
            update();

        }

    }

    public void update() {
        if (surchargeList.size() == 10) {
            this.goldclassSurcharge = surchargeList.get(0);
            this.platinumSurcharge = surchargeList.get(1);
            this.imaxSurcharge = surchargeList.get(2);
            this.blockbusterSurcharge = surchargeList.get(3);
            this.threedSurcharge = surchargeList.get(4);
            this.childDiscount = surchargeList.get(5);
            this.seniorCitizenDiscount = surchargeList.get(6);
            this.weekendSurcharge = surchargeList.get(7);
            this.holidaySurcharge = surchargeList.get(8);
            this.defaultTicketPrice = surchargeList.get(9);
        }

    }

    @SuppressWarnings("unchecked")
    public ArrayList<Double> readFromDB() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DataBaseFilePath));
            ArrayList<Double> surchargeList = (ArrayList<Double>) ois.readObject();
            ois.close();
            return surchargeList;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error when reading from surcharge DB");
            System.out.println(e);
        }
        return new ArrayList<Double>();
    }

    public void writeToDB(ArrayList<Double> surchargeList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DataBaseFilePath));
            out.writeObject(surchargeList);
            out.flush();
            out.close();
            update();
        } catch (IOException e) {
            System.out.print(e.toString());
            System.out.println("Error when writing to surcharge DB");
        }
    }

    public void clearDatabase() {
        while (surchargeList.size() > 0) {
            surchargeList.remove(0);
        }
        writeToDB(surchargeList);
        System.out.println("Clearing surcharge database");
    }

    public void editClassSurcharge(double goldclassSurcharge, double platinumSurcharge, double imaxSurcharge) {
        surchargeList.remove(0);
        surchargeList.add(0, goldclassSurcharge);
        surchargeList.remove(1);
        surchargeList.add(1, platinumSurcharge);
        surchargeList.remove(2);
        surchargeList.add(2, imaxSurcharge);
        writeToDB(surchargeList);
        update();
    }

    public void editTypeSurcharge(double blockbusterSurcharge, double threedSurcharge) {
        surchargeList.remove(3);
        surchargeList.add(3, blockbusterSurcharge);
        surchargeList.remove(4);
        surchargeList.add(4, threedSurcharge);
        writeToDB(surchargeList);
        update();
    }

    public void editAgeDiscount(double childDiscount, double seniorCitizenDiscount) {
        surchargeList.remove(5);
        surchargeList.add(5, childDiscount);
        surchargeList.remove(6);
        surchargeList.add(6, seniorCitizenDiscount);
        writeToDB(surchargeList);
        update();
    }

    public void editWeekendSurcharge(double weekendSurcharge, double holidaySurcharge) {
        surchargeList.remove(7);
        surchargeList.add(7, weekendSurcharge);
        surchargeList.remove(8);
        surchargeList.add(8, holidaySurcharge);
        writeToDB(surchargeList);
        update();
    }

    public void editDefaultTicketPrice(double defaultTicketPrice) {
        surchargeList.remove(9);
        surchargeList.add(9, defaultTicketPrice);
        writeToDB(surchargeList);
        update();
    }

    public void printSurcharges() {
        System.out.println("Gold Class Surcharge: " + goldclassSurcharge);
        System.out.println("Platinum Surcharge: " + platinumSurcharge);
        System.out.println("IMAX Surcharge: " + imaxSurcharge);
        System.out.println("Blockbuster Surcharge: " + blockbusterSurcharge);
        System.out.println("3D Surcharge: " + threedSurcharge);
        System.out.println("Student Discount: " + childDiscount);
        System.out.println("Senior Citizen Discount: " + seniorCitizenDiscount);
        System.out.println("Weekend Surcharge: " + weekendSurcharge);
        System.out.println("Holiday Surcharge: " + holidaySurcharge);
        System.out.println("Basic Ticket Price: " + defaultTicketPrice);
    }

    public void setSurcharges(double goldclassSurcharge, double platinumSurcharge, double imaxSurcharge,
            double blockbusterSurcharge, double threedSurcharge, double childDiscount,
            double seniorCitizenDiscount, double weekendSurcharge, double holidaySurcharge, double defaultTicketPrice) {
        ArrayList<Double> surchargeList = new ArrayList<Double>();
        surchargeList.add(goldclassSurcharge);
        surchargeList.add(platinumSurcharge);
        surchargeList.add(holidaySurcharge);
        surchargeList.add(blockbusterSurcharge);
        surchargeList.add(threedSurcharge);
        surchargeList.add(childDiscount);
        surchargeList.add(seniorCitizenDiscount);
        surchargeList.add(weekendSurcharge);
        surchargeList.add(holidaySurcharge);
        surchargeList.add(defaultTicketPrice);
        writeToDB(surchargeList);
        update();
    }

    // test
    public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        bookingController.printSurcharges();

    }

    // get ticket price based on type of movie,class of cinema, age, day of week or
    // public holiday
    public double getTicketPrice(Movie movie, Showtime showtime, User user) {
        double defaultPrice = defaultTicketPrice;
        // add price based on cinemaClass
        CinemaType cinemaClass = showtime.getCinema().getType();
        switch (cinemaClass) {
            case GOLDCLASS:
                defaultPrice += goldclassSurcharge;
                break;
            case PLATINUM:
                defaultPrice += platinumSurcharge;
                break;
            case IMAX:
                defaultPrice += imaxSurcharge;
                break;
            case NORMAL:
                break;
        }
        // add price based on movieType
        MovieType movieType = movie.getType();
        switch (movieType) {
            case Blockbuster:
                defaultPrice += blockbusterSurcharge;
                break;
            case ThreeD:
                defaultPrice += threedSurcharge;
                break;
            case Common:
                break;
        }
        // add price based on age
        AgeClass ageClass = getAgeClass(user, showtime);
        switch (ageClass) {
            case CHILD:
                defaultPrice -= childDiscount;
                break;
            case SENIORCITIZEN:
                defaultPrice -= seniorCitizenDiscount;
                break;
            case ADULT:
                break;
        }
        if (showtime.getIsHoliday()) {
            defaultPrice += holidaySurcharge;
        } else {
            int dayOfWeek = showtime.getStartTime().getDayOfWeek();
            switch (dayOfWeek) {
                case 1, 2, 3:
                    defaultPrice += weekendSurcharge;
                    break;
                case 4, 5, 6, 7:
                    break;
            }
        }

        return defaultPrice;
    }

    private AgeClass getAgeClass(User user, Showtime showtime) { // TODO this is just a rough one
        int showtimeYear; // showtimeMonth, showtimeDay;
        showtimeYear = showtime.getStartTime().getYear();
        // showtimeMonth = showtime.getStartTime().getMonth();
        // showtimeDay = showtime.getStartTime().getDay();
        String dob = user.getDateOfBirth();
        int dobYear; // dobMonth, dobDay;
        // dobDay = Integer.parseInt(dob.substring(0, 2));
        // dobMonth = Integer.parseInt(dob.substring(2, 4));
        // dob: 19/19/1919
        dobYear = Integer.parseInt(dob.substring(6, 10));
        int roughAge = showtimeYear - dobYear;
        if (roughAge > 65) {
            return AgeClass.SENIORCITIZEN;
        } else if (roughAge < 18) {
            return AgeClass.CHILD;
        } else {
            return AgeClass.ADULT;
        }

    }

    // get transaction id based on current time and cineplex and cinema code
    public String getTransactionID(Showtime selectedShowtime) {
        int hour = LocalTime.now().getHour();
        int minute = LocalTime.now().getMinute();
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        String cinemaName = selectedShowtime.getCinema().getName();
        String cinemaID = cinemaName.substring(cinemaName.length() - 1);
        String cineplexName = selectedShowtime.getCineplex().getName();
        String cineplexID = cineplexName.substring(0, 2).toUpperCase();
        String id = String.format("%s%s%04d%02d%02d%02d%02d", cineplexID, cinemaID, year, month, day, hour, minute);
        return id;
    }
}
