package rwanda_police;

public class ViolationEntry extends TrafficRecord {

    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void recordViolation() {
        // Validate driver ID
        if (!isValidDriverId()) {
            System.out.println("Error: Invalid Driver ID. Must be exactly 16 digits.");
            return;
        }

        // Validate vehicle plate
        if (!isValidVehiclePlate()) {
            System.out.println("Error: Invalid Vehicle Plate. Format should be RAB123D.");
            return;
        }

        // Validate violation type
        if (!isValidViolationType()) {
            System.out.println("Error: Invalid Violation Type. Must be SPEEDING, RED_LIGHT, NO_HELMET, or DUI.");
            return;
        }

        // Set initial payment status
        paymentStatus = "UNPAID";

        // Print confirmation
        System.out.println("Violation Record Created:");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Payment Status: " + paymentStatus);
    }

    @Override
    public void assessFine() {
        System.out.println("This class doesn't handle fine assessment.");
    }

    @Override
    public void processPayment() {
        System.out.println("This class doesn't handle payment processing.");
    }
}
