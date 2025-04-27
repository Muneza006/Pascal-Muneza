package lemigo_hotel;

public class GuestCheckout extends HotelService {

    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        System.out.println("This class doesn't handle room booking.");
    }

    @Override
    public void checkoutGuest() {
        // Check if room is occupied
        if (!"OCCUPIED".equalsIgnoreCase(roomStatus)) {
            System.out.println("Error: Cannot process checkout. Room is not occupied. Current status: " + roomStatus);
            return;
        }

        // Process successful checkout
        roomStatus = "AVAILABLE";
        System.out.println("Checkout Confirmation:");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Duration of Stay: " + stayDays + " days");
        System.out.println("Room Status: " + roomStatus);
        System.out.println("Checkout successful! Thank you for staying at LEMIGO HOTEL!");
    }

    @Override
    public void generateBill() {
        System.out.println("This class doesn't handle billing.");
    }
}