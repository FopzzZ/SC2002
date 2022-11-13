package Boundary.AdminMenu;

import Controller.*;
import Entity.Cinema.CinemaType;
import Entity.Cineplex.Cineplex;
/**
* AdminConfigSettingUI is an entity containing the user interface for an admin to configure settings
*/
public class AdminConfigSettingUI {
    BookingController bookingController;
    CineplexController cineplexController;

    
    public void main() {
        bookingController = new BookingController();
        cineplexController = new CineplexController();

        while (true) {
            System.out.println("\n" +
                    "------------------\n" +
                    "| Admin Settings |\n" +
                    "------------------\n" +
                    "1. Modify ticket prices\n" +
                    "2. Modify cineplexes\n" +
                    "3. Back to main menu\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 3)) {
                case 1:
                    modifyTicketPrices();
                    break;
                case 2:
                    modifyCineplex();
                    break;
                case 3:
                    return;
            }
        }
    }
    /** 
     * A method to display the menu for modifying ticket prices
     */
    private void modifyTicketPrices() {
        while (true) {
            System.out.println("\n" +
                    "------------------------\n" +
                    "| Modify Ticket Prices |\n" +
                    "------------------------\n" +
                    "1. Modify cinema class surcharge\n" +
                    "2. Modify movie type surcharge\n" +
                    "3. Modify holiday/weekend surcharge\n" +
                    "4. Modify student/senior citizen discount\n" +
                    "5. Modify basic ticket price\n" +
                    "6. Check current surcharges and discounts\n" +
                    "7. Back to admin settings\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 7)) {
                case 1:
                    modifyClassSurcharge();
                    break;
                case 2:
                    modifyTypeSurcharge();
                    break;
                case 3:
                    modifyWeekendSurcharge();
                    break;
                case 4:
                    modifyAgeDiscount();
                    break;
                case 5:
                    modifyDefaultTicketPrice();
                    break;
                case 6:
                    bookingController.printSurcharges();
                    break;
                case 7:
                    return;
            }
        }
    }

    /** 
     * A method to display the menu for modifying cineplexes
     */
    private void modifyCineplex() {
        while (true) {
            System.out.println("\n" +
                    "---------------------\n" +
                    "| Modify cineplexes |\n" +
                    "---------------------\n" +
                    "1. Add cineplex\n" +
                    "2. Remove cineplex\n" +
                    "3. Configure cineplex\n" +
                    "4. Back to admin settings\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 5)) {
                case 1:
                    addCineplex();
                    break;
                case 2:
                    removeCineplex();
                    break;
                case 3:
                    configureCineplex();
                    break;
                case 4:
                    return;

            }
        }
    }
    /** 
     * A method to display the menu for modifying class surcharges
     */
    private void modifyClassSurcharge() {
        double goldclassSurcharge, platinumSurcharge, imaxSurcharge;
        System.out.print("Enter Gold Class surcharge: ");
        goldclassSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter Platinum Class surcharge: ");
        platinumSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter IMAX surcharge: ");
        imaxSurcharge = InputController.getDoubleFromUser();
        bookingController.editClassSurcharge(goldclassSurcharge, platinumSurcharge, imaxSurcharge);

    }

    /** 
     * A method to display the menu for modifying type surcharges
     */
    private void modifyTypeSurcharge() {
        double blockbusterSurcharge, threedSurcharge;
        System.out.print("Enter Blockbuster surcharge: ");
        blockbusterSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter 3D surcharge: ");
        threedSurcharge = InputController.getDoubleFromUser();
        bookingController.editTypeSurcharge(blockbusterSurcharge, threedSurcharge);
    }

    /** 
     * A method to display the menu for modifying weekend surcharges
     */
    private void modifyWeekendSurcharge() {
        double weekendSurcharge, holidaySurcharge;
        System.out.print("Enter weekend surcharge: ");
        weekendSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter holiday surcharge: ");
        holidaySurcharge = InputController.getDoubleFromUser();
        bookingController.editWeekendSurcharge(weekendSurcharge, holidaySurcharge);
    }

    /** 
     * A method to display the menu for modifying age discount
     */
    private void modifyAgeDiscount() {
        double childDiscount, seniorCitizenDiscount;
        System.out.print("Enter student discount: ");
        childDiscount = InputController.getDoubleFromUser();
        System.out.print("Enter senior citizen: ");
        seniorCitizenDiscount = InputController.getDoubleFromUser();
        bookingController.editAgeDiscount(childDiscount, seniorCitizenDiscount);
    }

    /** 
     * A method to display the menu for modifying default ticket prices
     */
    private void modifyDefaultTicketPrice() {
        double defaultTicketPrice;
        System.out.print("Enter basic ticket price: ");
        defaultTicketPrice = InputController.getDoubleFromUser();
        bookingController.editDefaultTicketPrice(defaultTicketPrice);
    }

    /** 
     * A method to display the menu for adding cineplexes
     */
    private void addCineplex() {
        String cineplexName;
        System.out.println("Enter cineplex name: ");
        cineplexName = InputController.getStringFromUser();
        cineplexController.addNewCineplex(cineplexName);
    }

    /** 
     * A method to display the menu for removing cineplexes
     */
    private void removeCineplex() {
        cineplexController.listCineplex();
        System.out.println("Select cineplex to remove: ");
        int selection = InputController.getIntFromUser();
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(selection - 1);
        cineplexController.removeCineplex(selectedCineplex);
    }

    /** 
     * A method to display the menu for configuring cineplexes
     */
    private void configureCineplex() {
        cineplexController.listCineplex();
        System.out.println("Select cineplex to configure: ");
        int selection = InputController.getIntFromUser();
        Cineplex selectedCineplex = cineplexController.getCineplexList().get(selection - 1);
        while (true) {
            System.out.println("\n" +
                    "----------------------\n" +
                    "| Configure cineplex |\n" +
                    "----------------------\n" +
                    "1. Add cinema\n" +
                    "2. Change cinema type\n" +
                    "3. Back to modify cineplex\n");
            System.out.print("Select action: ");
            switch (InputController.getIntFromUser(1, 3)) {
                case 1:
                    addCinema(selectedCineplex);
                    break;
                case 2:
                    changeCinemaType(selectedCineplex);
                    break;
                case 3:
                    return;

            }
        }
    }

    
    /** 
     * A method that takes in a cineplex object and adds a cinema to it
     * 
     * @param cineplex Determines the cineplex to add the cinema to
     */
    private void addCinema(Cineplex cineplex) {
        cineplexController.addCinema(cineplex);
        System.out.println("Cinema added");
    }

    
    /** 
     * A method that takes in a cineplex and changes the type of one of its cinemas
     * 
     * @param cineplex Determines the cineplex to change the cinema type of
     */
    public void changeCinemaType(Cineplex cineplex) {
        cineplexController.listCinemas(cineplex);
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
        cineplexController.changeCinemaType(cineplex, selection - 1, newType);
        System.out.println("Cinema type changed");
    }

}
