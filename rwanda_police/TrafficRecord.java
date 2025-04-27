
package rwanda_police;

import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Rwanda National Police: Traffic Fine Management System =====");

        // Get driver details
        System.out.print("Enter Driver ID (16 digits): ");
        String driverId = scanner.nextLine();

        System.out.print("Enter Driver Name: ");
        String driverName = scanner.nextLine();

        System.out.print("Enter Vehicle Plate (e.g., RAB123D): ");
        String vehiclePlate = scanner.nextLine();

        // Violation type
        System.out.println("Available Violation Types:");
        System.out.println("1. SPEEDING");
        System.out.println("2. RED_LIGHT");
        System.out.println("3. NO_HELMET");
        System.out.println("4. DUI");
        System.out.print("Select Violation Type (1-4): ");
        int violationTypeChoice = scanner.nextInt();

        String violationType;
        switch (violationTypeChoice) {
            case 1:
                violationType = "SPEEDING";
                break;
            case 2:
                violationType = "RED_LIGHT";
                break;
            case 3:
                violationType = "NO_HELMET";
                break;
            case 4:
                violationType = "DUI";
                break;
            default:
                violationType = "SPEEDING";
                System.out.println("Invalid choice. Defaulting to SPEEDING violation.");
        }

        // Variable to track state across operations
        double currentFineAmount = 0.0;
        String currentPaymentStatus = "UNPAID";

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Record Traffic Violation");
            System.out.println("2. Assess Fine");
            System.out.println("3. Process Payment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ViolationEntry violationEntry = new ViolationEntry(driverId, driverName, vehiclePlate, violationType);
                    violationEntry.recordViolation();
                    currentPaymentStatus = violationEntry.getPaymentStatus();
                    break;

                case 2:
                    FineAssessment fineAssessment = new FineAssessment(driverId, driverName, vehiclePlate, violationType);
                    fineAssessment.assessFine();
                    currentFineAmount = fineAssessment.getFineAmount();
                    break;

                case 3:
                    FinePayment finePayment = new FinePayment(
                            driverId, driverName, vehiclePlate, violationType, currentFineAmount, currentPaymentStatus
                    );
                    finePayment.processPayment();
                    currentPaymentStatus = finePayment.getPaymentStatus();
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