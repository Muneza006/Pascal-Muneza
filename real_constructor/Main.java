package real_constructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== REAL CONSTRUCTOR: Site Construction Management System =====");

        // Get contractor details
        System.out.print("Enter Contractor ID: ");
        String contractorId = scanner.nextLine();

        System.out.print("Enter Contractor Name: ");
        String contractorName = scanner.nextLine();

        // Initial material balance
        System.out.print("Enter initial material balance (tons): ");
        double initialBalance = scanner.nextDouble();

        int choice;
        do {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Receive Material");
            System.out.println("2. Use Material");
            System.out.println("3. Estimate Cost");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity to receive (tons): ");
                    double receiveQuantity = scanner.nextDouble();

                    MaterialDelivery delivery = new MaterialDelivery(
                            contractorId, contractorName, receiveQuantity, initialBalance
                    );
                    delivery.receiveMaterial();
                    initialBalance = delivery.getMaterialBalance();
                    break;

                case 2:
                    System.out.print("Enter quantity to use (tons): ");
                    double useQuantity = scanner.nextDouble();

                    MaterialUsage usage = new MaterialUsage(
                            contractorId, contractorName, useQuantity, initialBalance
                    );
                    usage.useMaterial();
                    initialBalance = usage.getMaterialBalance();
                    break;

                case 3:
                    System.out.print("Enter quantity for cost estimation (tons): ");
                    double estimateQuantity = scanner.nextDouble();

                    CostEstimation costEstimation = new CostEstimation(
                            contractorId, contractorName, estimateQuantity, initialBalance
                    );
                    costEstimation.estimateCost();
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