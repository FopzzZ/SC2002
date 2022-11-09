package Boundary.AdminMenu;

import Controller.*;

public class AdminConfigSettingUI {
    BookingController bookingController;

    public void main() {
        bookingController = new BookingController();
        while (true) {
            System.out.println("\n" +
                    "------------------------\n" +
                    "| Modify Ticket Prices |\n" +
                    "------------------------\n" +
                    "1. Modify cinema class surcharge\n" +
                    "2. Modify movie type surcharge\n" +
                    "3. Modify holiday/weekend surcharge\n" +
                    "4. Modify student/senior citizen discount\n" +
                    "5. Modify default ticket price\n" +
                    "6. Check current surcharges and discounts\n" +
                    "7. Back to main menu\n");
            System.out.println("Select action: ");
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

    private void modifyTypeSurcharge() {
        double blockbusterSurcharge, threedSurcharge;
        System.out.print("Enter Blockbuster surcharge: ");
        blockbusterSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter 3D surcharge: ");
        threedSurcharge = InputController.getDoubleFromUser();
        bookingController.editTypeSurcharge(blockbusterSurcharge, threedSurcharge);
    }

    private void modifyWeekendSurcharge() {
        double weekendSurcharge, holidaySurcharge;
        System.out.print("Enter weekend surcharge: ");
        weekendSurcharge = InputController.getDoubleFromUser();
        System.out.print("Enter holiday surcharge: ");
        holidaySurcharge = InputController.getDoubleFromUser();
        bookingController.editWeekendSurcharge(weekendSurcharge, holidaySurcharge);
    }

    private void modifyAgeDiscount() {
        double childDiscount, seniorCitizenDiscount;
        System.out.print("Enter child discount: ");
        childDiscount = InputController.getDoubleFromUser();
        System.out.print("Enter senior citizen: ");
        seniorCitizenDiscount = InputController.getDoubleFromUser();
        bookingController.editAgeDiscount(childDiscount, seniorCitizenDiscount);
    }

    private void modifyDefaultTicketPrice() {
        double defaultTicketPrice;
        System.out.print("Enter default ticket price: ");
        defaultTicketPrice = InputController.getDoubleFromUser();
        bookingController.editDefaultTicketPrice(defaultTicketPrice);
    }

    public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        bookingController.clearDatabase();
        bookingController.setSurcharges(2, 4, 5,
                2, 3, 5,
                5, 2, 3, 8);
        AdminConfigSettingUI adminConfigSettingUI = new AdminConfigSettingUI();
        adminConfigSettingUI.main();
    }
}