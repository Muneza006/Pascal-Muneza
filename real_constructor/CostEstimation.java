package real_constructor;

import java.text.NumberFormat;
import java.util.Locale;

public class CostEstimation extends ConstructionMaterial {

    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        System.out.println("This class doesn't handle material reception.");
    }

    @Override
    public void useMaterial() {
        System.out.println("This class doesn't handle material usage.");
    }

    @Override
    public void estimateCost() {
        double costPerTon;

        if (materialQuantity > 5 && materialQuantity <= 15) {
            costPerTon = 200000;
        } else if (materialQuantity > 15) {
            costPerTon = 180000;
        } else {
            costPerTon = 220000; // Default cost for small quantities
        }

        double totalCost = materialQuantity * costPerTon;

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));

        System.out.println("Cost Estimation Details:");
        System.out.println("Contractor ID: " + contractorId);
        System.out.println("Contractor Name: " + contractorName);
        System.out.println("Material Quantity Used: " + materialQuantity + " tons");
        System.out.println("Cost per Ton: " + currencyFormatter.format(costPerTon));
        System.out.println("Total Cost: " + currencyFormatter.format(totalCost));
    }
}
