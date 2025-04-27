package real_constructor;

public class MaterialUsage extends ConstructionMaterial {

    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        System.out.println("This class doesn't handle material reception.");
    }

    @Override
    public void useMaterial() {
        if (materialBalance - materialQuantity >= 2) {
            materialBalance -= materialQuantity;
            System.out.println("Material used successfully. Remaining balance: " + materialBalance + " tons");
        } else {
            System.out.println("Error: Insufficient material. Usage would reduce balance below 2 tons.");
            System.out.println("Current balance: " + materialBalance + " tons, Requested usage: " + materialQuantity + " tons");
        }
    }

    @Override
    public void estimateCost() {
        System.out.println("This class doesn't handle cost estimation.");
    }
}