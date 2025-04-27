package lemigo_hotel;

import java.text.NumberFormat;
import java.util.Locale;

public class Billing extends HotelService {

    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        System.out.println("This class doesn't handle room booking.");
    }

    @Override
    public void checkoutGuest() {
        System.out.println("This class doesn't handle guest checkout.");
    }

    @Override
    public void generateBill() {
        if (!isValidRoomType()) {
            System.out.println("Error: Invalid room type. Must be STANDARD, DELUXE, or SUITE");
            return;
        }

        int costPerNight = 0;
        switch (roomType.toUpperCase()) {
            case "STANDARD":
                costPerNight = 50000;
                break;
            case "DELUXE":
                costPerNight = 80000;
                break;
            case "SUITE":
                costPerNight = 120000;
                break;
        }

        double totalCost = costPerNight * stayDays;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));

        System.out.println("LEMIGO HOTEL - Billing Statement");
        System.out.println("==============================");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " days");
        System.out.println("Rate per Night: " + currencyFormatter.format(costPerNight));
        System.out.println("-------------------------------");
        System.out.println("Total Cost: " + currencyFormatter.format(totalCost));
        System.out.println("==============================");
    }

    private boolean isValidRoomType() {
        return "STANDARD".equalsIgnoreCase(roomType) ||
                "DELUXE".equalsIgnoreCase(roomType) ||
                "SUITE".equalsIgnoreCase(roomType);
    }
}
