package rwanda_police;

 abstract class TrafficRecord {
    // Common attributes
    protected String driverId;
    protected String driverName;
    protected String vehiclePlate;
    protected String violationType;
    protected double fineAmount;
    protected String paymentStatus;

    // Constructor
    public TrafficRecord(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.fineAmount = 0.0;
        this.paymentStatus = "UNPAID";
    }

    // Abstract methods
    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void processPayment();

    // Getters and setters
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Validate driver ID (16 digits)
    protected boolean isValidDriverId() {
        return driverId != null && driverId.matches("\\d{16}");
    }

    // Validate vehicle plate (e.g., RAB123D)
    protected boolean isValidVehiclePlate() {
        return vehiclePlate != null && vehiclePlate.matches("[A-Z]{3}\\d{3}[A-Z]");
    }

    // Validate violation type
    protected boolean isValidViolationType() {
        return "SPEEDING".equalsIgnoreCase(violationType) ||
                "RED_LIGHT".equalsIgnoreCase(violationType) ||
                "NO_HELMET".equalsIgnoreCase(violationType) ||
                "DUI".equalsIgnoreCase(violationType);
    }
}
