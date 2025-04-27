package real_constructor;

public class MaterialDelivery extends ConstructionMaterial {

    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        if (materialQuantity >= 1 && materialQuantity <= 10) {
            materialBalance += materialQuantity;
            System.out.println("Delivery successful. Current material balance: " + materialBalance + " tons");
        } else {
            System.out.println("Error: Delivery quantity must be between 1 and 10 tons. Received: " + materialQuantity + " tons");
        }
    }

    @Override
    public void useMaterial() {
        System.out.println("This class doesn't handle material usage.");
    }

    @Override
    public void estimateCost() {
        System.out.println("This class doesn't handle cost estimation.");
    }
}