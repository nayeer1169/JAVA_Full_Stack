// We do not define a package statement here to keep compilation very simple for a beginner.

// We declare 'Vehicle' as an abstract class using the 'abstract' keyword.
// This implements ABSTRACTION. You cannot instantiate a generic Vehicle directly (i.e. 'new Vehicle(...)' is not allowed).
// It acts as a template for more specific vehicles like Car, Motorcycle, and Truck.
public abstract class Vehicle {

    // Private variables are accessible only within this class (Encapsulation).
    // Access is provided via controlled public getter and setter methods.
    private String vehicleId;
    private String brand;
    private String model;
    private double baseRatePerDay;
    private boolean isRented;

    // Constructor to initialize a Vehicle object.
    // When a subclass is created, its constructor calls this base constructor using 'super(...)'.
    public Vehicle(String vehicleId, String brand, String model, double baseRatePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        
        // We use the setter method here so the validation logic is applied at creation time.
        setBaseRatePerDay(baseRatePerDay);
        this.isRented = false;
    }

    // Getter method for Vehicle ID (Encapsulation: read access).
    public String getVehicleId() {
        return vehicleId;
    }

    // Setter method for Vehicle ID (Encapsulation: write access).
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Getter method for Brand.
    public String getBrand() {
        return brand;
    }

    // Setter method for Brand.
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter for Model.
    public String getModel() {
        return model;
    }

    // Setter for Model.
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for Base Rate.
    public double getBaseRatePerDay() {
        return baseRatePerDay;
    }

    // Setter for Base Rate with validation.
    // Encapsulation allows us to intercept invalid data (like negative rates) before setting the value.
    public void setBaseRatePerDay(double baseRatePerDay) {
        if (baseRatePerDay >= 0) {
            this.baseRatePerDay = baseRatePerDay;
        } else {
            System.out.println("Warning: Rental rate cannot be negative. Setting base rate to 0.0.");
            this.baseRatePerDay = 0.0;
        }
    }

    // Getter for status.
    public boolean isRented() {
        return isRented;
    }

    // Setter for status.
    public void setRented(boolean rented) {
        this.isRented = rented;
    }

    // Methods to modify the state of the vehicle
    public void rent() {
        this.isRented = true;
    }

    public void returnVehicle() {
        this.isRented = false;
    }

    // Abstract method that MUST be implemented by any concrete subclass.
    // This demonstrates ABSTRACTION. The base class defines the signature (the 'what'),
    // while the subclasses define the implementation details (the 'how').
    public abstract double calculateRentalCost(int days);

    // Overriding toString() from the Object class to return a user-friendly string representation.
    @Override
    public String toString() {
        return String.format("ID: %-6s | %-12s | %-12s | Base Rate: $%-6.2f | Status: %s",
                vehicleId, brand, model, baseRatePerDay, (isRented ? "Rented" : "Available"));
    }
}
