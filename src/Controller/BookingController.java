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

/**
 * Controller to manage bookings
 */
public class BookingController {
    private double goldclassSurcharge, platinumSurcharge, imaxSurcharge, blockbusterSurcharge,
            threedSurcharge, childDiscount,
            seniorCitizenDiscount, weekendSurcharge, holidaySurcharge, defaultTicketPrice;

    private final static String DataBaseFilePath = "database/Surcharges.txt";
    private static ArrayList<Double> surchargeList;

    /**
     * Class constructor
     */
    public BookingController() {
        surchargeList = new ArrayList<Double>();
        File dbFile = new File(DataBaseFilePath);
        if (dbFile.exists()) {
            surchargeList = readFromDB();
            update();

        }

    }

    /**
     * Update variables from list
     */
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

    /**
     * Read surcharge list from database
     * 
     * @return ArrayList<Double> current surcharge list
     */
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

    /**
     * Write current surcharge list to database
     * 
     * @param surchargeList current list
     */
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

    /**
     * Clear database
     */
    public void clearDatabase() {
        while (surchargeList.size() > 0) {
            surchargeList.remove(0);
        }
        writeToDB(surchargeList);
        System.out.println("Clearing surcharge database");
    }

    /**
     * Update surcharges that depend on class
     * 
     * @param goldclassSurcharge Gold Class surcharge
     * @param platinumSurcharge  Platinum Class surcharge
     * @param imaxSurcharge      IMAX surcharge
     */
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

    /**
     * Update surcharges that depend on movie type
     * 
     * @param blockbusterSurcharge Blockbuster surcharge
     * @param threedSurcharge      3D surcharge
     */
    public void editTypeSurcharge(double blockbusterSurcharge, double threedSurcharge) {
        surchargeList.remove(3);
        surchargeList.add(3, blockbusterSurcharge);
        surchargeList.remove(4);
        surchargeList.add(4, threedSurcharge);
        writeToDB(surchargeList);
        update();
    }

    /**
     * Update surcharges that depend on age of buyer
     * 
     * @param childDiscount         Child/student discount
     * @param seniorCitizenDiscount Senior citizen discount
     */
    public void editAgeDiscount(double childDiscount, double seniorCitizenDiscount) {
        surchargeList.remove(5);
        surchargeList.add(5, childDiscount);
        surchargeList.remove(6);
        surchargeList.add(6, seniorCitizenDiscount);
        writeToDB(surchargeList);
        update();
    }

    /**
     * Update surcharges that depend on day of week/holiday
     * 
     * @param weekendSurcharge Weekend surcharge (Fri/Sat/Sun)
     * @param holidaySurcharge Public holiday surcharge
     */
    public void editWeekendSurcharge(double weekendSurcharge, double holidaySurcharge) {
        surchargeList.remove(7);
        surchargeList.add(7, weekendSurcharge);
        surchargeList.remove(8);
        surchargeList.add(8, holidaySurcharge);
        writeToDB(surchargeList);
        update();
    }

    /**
     * Update basic ticket price
     * 
     * @param defaultTicketPrice Basic ticket price
     */
    public void editDefaultTicketPrice(double defaultTicketPrice) {
        surchargeList.remove(9);
        surchargeList.add(9, defaultTicketPrice);
        writeToDB(surchargeList);
        update();
    }

    /**
     * Print surcharge list
     */
    public void printSurcharges() {
        System.out.println("\n" +
                "------------------\n" +
                "| All Surcharges |\n" +
                "------------------");
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

    /**
     * Set surcharges, for initialisation, parameters are self explanatory
     * 
     * @param goldclassSurcharge
     * @param platinumSurcharge
     * @param imaxSurcharge
     * @param blockbusterSurcharge
     * @param threedSurcharge
     * @param childDiscount
     * @param seniorCitizenDiscount
     * @param weekendSurcharge
     * @param holidaySurcharge
     * @param defaultTicketPrice
     */
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

    /**
     * Calculates ticket price based on movie class, type, day of week and age of
     * buyer
     * 
     * @param movie    movie
     * @param showtime showtime of the movie
     * @param user     user that is buying the ticket
     * @return double price of the ticket
     */
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
        if (defaultPrice <= 1) { // min price 1 dollar
            defaultPrice = 1.0;
        }
        return defaultPrice;
    }

    /**
     * Calculates what age group buyer is in
     * 
     * @param user     user that is making the booking
     * @param showtime showtime of the movie
     * @return AgeClass age group of user
     */
    private AgeClass getAgeClass(User user, Showtime showtime) {
        int showtimeYear; // showtimeMonth, showtimeDay;
        showtimeYear = showtime.getStartTime().getYear();
        String dob = user.getDateOfBirth();
        int dobYear;
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

    /**
     * Generates transaction id for a booking
     * 
     * @param selectedShowtime selected showtime of the movie
     * @return String transaction id of the booking
     */
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

    /**
     * Get basic ticket price
     * 
     * @return double basic ticket price
     */
    public double getDefaultPrice() {
        return defaultTicketPrice;
    }
}
