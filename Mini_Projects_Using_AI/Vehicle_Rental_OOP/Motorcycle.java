// No package statement for simple compilation.

// The 'extends' keyword demonstrates INHERITANCE.
// Motorcycle inherits all properties and methods of the Vehicle base class.
public class Motorcycle extends Vehicle {

    // Encapsulation: Subclass-specific private property
    private boolean includesHelmet;

    // Subclass constructor
    public Motorcycle(String vehicleId, String brand, String model, double baseRatePerDay, boolean includesHelmet) {
        // Calls the constructor of the parent class (Vehicle).
        super(vehicleId, brand, model, baseRatePerDay);
        this.includesHelmet = includesHelmet;
    }

    // Getter for includesHelmet (Encapsulation)
    public boolean includesHelmet() {
        return includesHelmet;
    }

    // Setter for includesHelmet (Encapsulation)
    public void setIncludesHelmet(boolean includesHelmet) {
        this.includesHelmet = includesHelmet;
    }

    // Overriding the abstract method. Demonstrates POLYMORPHISM.
    // If the helmet rental is included, there is a flat $5.00 surcharge per day.
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) {
            return 0.0;
        }
        double baseCost = getBaseRatePerDay() * days;
        double helmetCost = includesHelmet ? (5.00 * days) : 0.0;
        return baseCost + helmetCost;
    }

    // Overriding toString to append Motorcycle-specific details.
    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: Motorcycle | Helmet Rental: %s", (includesHelmet ? "Yes (+$5.00/day)" : "No"));
    }
}
