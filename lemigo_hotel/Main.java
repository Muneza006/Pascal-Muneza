package lemigo_hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== LEMIGO HOTEL: Hotel Management System =====");

        // Get guest details
        System.out.print("Enter Guest ID: ");
        String guestId = scanner.nextLine();

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        // Room type
        System.out.println("Available Room Types:");
        System.out.println("1. STANDARD");
        System.out.println("2. DELUXE");
        System.out.println("3. SUITE");
        System.out.print("Select Room Type (1-3): ");
        int roomTypeChoice = scanner.nextInt();

        String roomType;
        switch (roomTypeChoice) {
            case 1:
                roomType = "STANDARD";
                break;
            case 2:
                roomType = "DELUXE";
                break;
            case 3:
                roomType = "SUITE";
                break;
            default:
                roomType = "STANDARD";
                System.out.println("Invalid choice. Defaulting to STANDARD room.");
        }

        // Stay duration
        System.out.print("Enter Stay Duration (days): ");
        int stayDays = scanner.nextInt();

        // Initial room status
        String roomStatus = "AVAILABLE";

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Book Room");
            System.out.println("2. Checkout Guest");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    RoomBooking booking = new RoomBooking(guestId, guestName, roomType, stayDays, roomStatus);
                    booking.bookRoom();
                    roomStatus = booking.getRoomStatus();
                    break;

                case 2:
                    GuestCheckout checkout = new GuestCheckout(guestId, guestName, roomType, stayDays, roomStatus);
                    checkout.checkoutGuest();
                    roomStatus = checkout.getRoomStatus();
                    break;

                case 3:
                    Billing billing = new Billing(guestId, guestName, roomType, stayDays, roomStatus);
                    billing.generateBill();
                    break;

                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}