package lemigo_hotel;

public class RoomBooking extends HotelService {

    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        // Validate stay days between 1 and 30
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("Error: Stay duration must be between 1 and 30 days. Requested: " + stayDays + " days");
            return;
        }

        // Validate room type
        if (!isValidRoomType()) {
            System.out.println("Error: Invalid room type. Must be STANDARD, DELUXE, or SUITE");
            return;
        }

        // Check room status
        if (!"AVAILABLE".equalsIgnoreCase(roomStatus)) {
            System.out.println("Error: Room is not available for booking. Current status: " + roomStatus);
            return;
        }

        // Process successful booking
        roomStatus = "OCCUPIED";
        System.out.println("Booking Confirmation:");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " days");
        System.out.println("Room Status: " + roomStatus);
        System.out.println("Booking successful! Welcome to LEMIGO HOTEL!");
    }

    private boolean isValidRoomType() {
        return "STANDARD".equalsIgnoreCase(roomType) ||
                "DELUXE".equalsIgnoreCase(roomType) ||
                "SUITE".equalsIgnoreCase(roomType);
    }

    @Override
    public void checkoutGuest() {
        System.out.println("This class doesn't handle guest checkout.");
    }

    @Override
    public void generateBill() {
        System.out.println("This class doesn't handle billing.");
    }
}
