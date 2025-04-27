package rwanda_police;

import java.text.NumberFormat;
import java.util.Locale;

public class FineAssessment extends TrafficRecord {

    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType) {
        super(driverId, driverName, vehiclePlate, violationType);
    }

    @Override
    public void recordViolation() {
        System.out.println("This class doesn't handle violation recording.");
    }

    @Override
    public void assessFine() {
        // Validate violation type
        if (!isValidViolationType()) {
            System.out.println("Error: Invalid Violation Type. Must be SPEEDING, RED_LIGHT, NO_HELMET, or DUI.");
            return;
        }

        // Determine fine amount based on violation type
        switch (violationType.toUpperCase()) {
            case "SPEEDING":
                fineAmount = 50000;
                break;
            case "RED_LIGHT":
                fineAmount = 80000;
                break;
            case "NO_HELMET":
                fineAmount = 30000;
                break;
            case "DUI":
                fineAmount = 150000;
                break;
            default:
                System.out.println("Error: Unknown violation type.");
                return;
        }

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));

        // Display fine details
        System.out.println("Fine Assessment Details:");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Fine Amount: " + currencyFormatter.format(fineAmount));
        System.out.println("Payment Status: " + paymentStatus);
    }

    @Override
    public void processPayment() {
        System.out.println("This class doesn't handle payment processing.");
    }
}
