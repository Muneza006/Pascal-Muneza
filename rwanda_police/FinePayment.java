package rwanda_police;

import java.text.NumberFormat;
import java.util.Locale;

public class FinePayment extends TrafficRecord {

    public FinePayment(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType);
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public void recordViolation() {
        System.out.println("This class doesn't handle violation recording.");
    }

    @Override
    public void assessFine() {
        System.out.println("This class doesn't handle fine assessment.");
    }

    @Override
    public void processPayment() {
        // Check if already paid
        if ("PAID".equalsIgnoreCase(paymentStatus)) {
            System.out.println("Error: This fine has already been paid.");
            return;
        }

        // Process payment
        paymentStatus = "PAID";

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));

        // Display receipt
        System.out.println("Payment Receipt:");
        System.out.println("==================================");
        System.out.println("RWANDA NATIONAL POLICE");
        System.out.println("Traffic Fine Payment Receipt");
        System.out.println("==================================");
        System.out.println("Driver ID: " + driverId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Fine Amount: " + currencyFormatter.format(fineAmount));
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("==================================");
        System.out.println("Thank you for your payment.");
    }
}
