// ==========================================
// 1. JAVA CODE CONSTANTS FOR EXPLORER
// ==========================================
const JAVA_CODE = {
    "Vehicle.java": `// We do not define a package statement here to keep compilation very simple for a beginner.

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
    public Vehicle(String vehicleId, String brand, String model, double baseRatePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        setBaseRatePerDay(baseRatePerDay); // Encapsulation validation
        this.isRented = false;
    }

    // Getters and Setters (Encapsulation)
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getBaseRatePerDay() { return baseRatePerDay; }

    // Setter with business logic validation (Encapsulation)
    public void setBaseRatePerDay(double baseRatePerDay) {
        if (baseRatePerDay >= 0) {
            this.baseRatePerDay = baseRatePerDay;
        } else {
            System.out.println("Warning: Rental rate cannot be negative. Setting base rate to 0.0.");
            this.baseRatePerDay = 0.0;
        }
    }

    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { this.isRented = rented; }

    public void rent() { this.isRented = true; }
    public void returnVehicle() { this.isRented = false; }

    /**
     * Abstract method that MUST be implemented by any concrete subclass.
     * Demonstrates ABSTRACTION.
     */
    public abstract double calculateRentalCost(int days);

    @Override
    public String toString() {
        return String.format("ID: %-6s | %-12s | %-12s | Base Rate: $%-6.2f | Status: %s",
                vehicleId, brand, model, baseRatePerDay, (isRented ? "Rented" : "Available"));
    }
}`,
    "Car.java": `// No package statement to make compilation simple.

// The 'extends' keyword demonstrates INHERITANCE.
// Car inherits all fields and methods of the Vehicle base class.
public class Car extends Vehicle {
    
    // Encapsulation: Subclass-specific private property
    private boolean hasInsurance;

    // Subclass constructor invoking parent constructor using 'super'
    public Car(String vehicleId, String brand, String model, double baseRatePerDay, boolean hasInsurance) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.hasInsurance = hasInsurance;
    }

    public boolean hasInsurance() { return hasInsurance; }
    public void setInsurance(boolean hasInsurance) { this.hasInsurance = hasInsurance; }

    /**
     * Calculates the rental cost for a Car.
     * Demonstrates POLYMORPHISM (Method Overriding / Runtime Polymorphism).
     * Includes base rate plus a surcharge of $15/day if insurance is active.
     */
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) return 0.0;
        double baseCost = getBaseRatePerDay() * days;
        double insuranceCost = hasInsurance ? (15.00 * days) : 0.0;
        return baseCost + insuranceCost;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: Car        | Insurance: %s", (hasInsurance ? "Yes (+$15.00/day)" : "No"));
    }
}`,
    "Motorcycle.java": `// No package statement for simple compilation.

// The 'extends' keyword demonstrates INHERITANCE.
public class Motorcycle extends Vehicle {

    // Encapsulation: Subclass-specific private property
    private boolean includesHelmet;

    public Motorcycle(String vehicleId, String brand, String model, double baseRatePerDay, boolean includesHelmet) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.includesHelmet = includesHelmet;
    }

    public boolean includesHelmet() { return includesHelmet; }
    public void setIncludesHelmet(boolean includesHelmet) { this.includesHelmet = includesHelmet; }

    /**
     * Calculates the rental cost for a Motorcycle.
     * Demonstrates POLYMORPHISM.
     * Adds a flat $5.00/day surcharge if helmet rental is selected.
     */
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) return 0.0;
        double baseCost = getBaseRatePerDay() * days;
        double helmetCost = includesHelmet ? (5.00 * days) : 0.0;
        return baseCost + helmetCost;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: Motorcycle | Helmet Rental: %s", (includesHelmet ? "Yes (+$5.00/day)" : "No"));
    }
}`,
    "Truck.java": `// No package statement for simple compilation.

// The 'extends' keyword demonstrates INHERITANCE.
public class Truck extends Vehicle {

    // Encapsulation: Subclass-specific private property (cargo capacity in tons)
    private double cargoCapacity;

    public Truck(String vehicleId, String brand, String model, double baseRatePerDay, double cargoCapacity) {
        super(vehicleId, brand, model, baseRatePerDay);
        setCargoCapacity(cargoCapacity); // Validation through setter
    }

    public double getCargoCapacity() { return cargoCapacity; }
    
    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity >= 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            System.out.println("Warning: Cargo capacity cannot be negative. Setting capacity to 0.0 tons.");
            this.cargoCapacity = 0.0;
        }
    }

    /**
     * Calculates the rental cost for a Truck.
     * Demonstrates POLYMORPHISM.
     * Surcharge logic: adds a surcharge of $20.00 per ton per day.
     */
    @Override
    public double calculateRentalCost(int days) {
        if (days < 0) return 0.0;
        double baseCost = getBaseRatePerDay() * days;
        double capacitySurcharge = cargoCapacity * 20.00 * days;
        return baseCost + capacitySurcharge;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: Truck      | Capacity: %.1f Tons (+$%.2f/day)", cargoCapacity, (cargoCapacity * 20.00));
    }
}`,
    "RentalAgency.java": `// No package statement for simple compilation.

/**
 * RentalAgency class that manages the fleet of vehicles.
 * 
 * Demonstrates POLYMORPHISM & Dynamic Method Dispatch:
 * - Keeps all vehicles in a unified array of 'Vehicle' references.
 * - Iterating and calling overridden methods calculateRentalCost() dynamically 
 *   resolves to the correct subclass at runtime.
 */
public class RentalAgency {
    
    // Encapsulation: Private inventory fields
    private Vehicle[] inventory; // Array of Vehicle objects (demonstrates Polymorphic reference type)
    private int vehicleCount;    // Tracks the current number of vehicles added to the inventory

    public RentalAgency(int capacity) {
        this.inventory = new Vehicle[capacity];
        this.vehicleCount = 0;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) return;
        if (vehicleCount >= inventory.length) {
            System.out.println("Error: Inventory capacity reached.");
            return;
        }
        inventory[vehicleCount] = vehicle;
        vehicleCount++;
    }

    public void displayInventory() {
        System.out.println("\\n=================================== VEHICLE INVENTORY ===================================");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(inventory[i].toString()); // Polymorphic toString
        }
        System.out.println("=========================================================================================");
    }

    public Vehicle findVehicle(String vehicleId) {
        for (int i = 0; i < vehicleCount; i++) {
            if (inventory[i].getVehicleId().equalsIgnoreCase(vehicleId.trim())) {
                return inventory[i];
            }
        }
        return null;
    }

    public void rentVehicle(String vehicleId, int days) {
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null || vehicle.isRented()) return;

        vehicle.rent();
        double cost = vehicle.calculateRentalCost(days); // POLYMORPHIC METHOD CALL

        System.out.println("\\n-------------------------------------------");
        System.out.println("             RENTAL TRANSACTION             ");
        System.out.println("-------------------------------------------");
        System.out.println("Status        : APPROVED");
        System.out.println("Vehicle Model : " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        System.out.println("Rental Period : " + days + " day(s)");
        System.out.println("Total Due     : $" + String.format("%.2f", cost));
        System.out.println("-------------------------------------------");
    }

    public void returnVehicle(String vehicleId) {
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null || !vehicle.isRented()) return;

        vehicle.returnVehicle();
        System.out.println("\\n-------------------------------------------");
        System.out.println("             RETURN TRANSACTION             ");
        System.out.println("-------------------------------------------");
        System.out.println("Status        : SUCCESS");
        System.out.println("Vehicle Model : " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getVehicleId() + ")");
        System.out.println("Current Status: Available for rent");
        System.out.println("-------------------------------------------");
    }

    public void displayStats() {
        int total = vehicleCount;
        int rented = 0;
        double totalBaseRevenuePotential = 0.0;

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle v = inventory[i];
            if (v.isRented()) rented++;
            totalBaseRevenuePotential += v.getBaseRatePerDay();
        }

        System.out.println("\\n=================== AGENCY STATS ===================");
        System.out.println("Total Fleet Count      : " + total);
        System.out.println("Currently Rented       : " + rented);
        System.out.println("Available for Rent     : " + (total - rented));
        System.out.println("Base Daily Revenue Cap : $" + String.format("%.2f", totalBaseRevenuePotential));
        System.out.println("====================================================");
    }
}`,
    "Main.java": `// No package statement for simple compilation.

import java.util.Scanner;

/**
 * Main Class - The CLI Driver program.
 * 
 * Demonstrates:
 * 1. Abstraction  : Use of the 'Vehicle' abstract class as a general template.
 * 2. Encapsulation: Accessing fields only via methods like 'getBrand()', 'isRented()', etc.
 * 3. Inheritance  : 'Car', 'Motorcycle', and 'Truck' extending 'Vehicle'.
 * 4. Polymorphism : Upcasting subclasses into 'Vehicle[]' array and dynamic dispatch.
 */
public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency(10);

        // Prepopulate inventory with different subclasses (Polymorphism / Upcasting)
        agency.addVehicle(new Car("C001", "Toyota", "Camry", 50.00, true));
        agency.addVehicle(new Car("C002", "Honda", "Civic", 40.00, false));
        agency.addVehicle(new Car("C003", "Tesla", "Model 3", 85.00, true));
        
        agency.addVehicle(new Motorcycle("M001", "Harley-Davidson", "Sportster", 60.00, true));
        agency.addVehicle(new Motorcycle("M002", "Kawasaki", "Ninja 400", 35.00, false));
        
        agency.addVehicle(new Truck("T001", "Ford", "F-150", 75.00, 1.5));
        agency.addVehicle(new Truck("T002", "Chevrolet", "Silverado", 80.00, 2.0));
        agency.addVehicle(new Truck("T003", "Volvo", "Heavy Hauler", 250.00, 18.0));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=========================================================================");
        System.out.println("               W E L C O M E  T O  O O P  R E N T A L S                  ");
        System.out.println("=========================================================================");

        while (!exit) {
            System.out.println("\\n1. List All Vehicles\\n2. Rent a Vehicle\\n3. Return a Vehicle\\n4. Inspect Vehicle\\n5. Show Stats\\n6. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine(); // clear buffer
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: agency.displayInventory(); break;
                case 2:
                    System.out.print("Enter Vehicle ID to rent: ");
                    String rentId = scanner.nextLine();
                    System.out.print("Enter duration in days: ");
                    int days = scanner.nextInt();
                    agency.rentVehicle(rentId, days);
                    break;
                case 3:
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnId = scanner.nextLine();
                    agency.returnVehicle(returnId);
                    break;
                case 4:
                    System.out.print("Enter Vehicle ID to inspect: ");
                    String inspectId = scanner.nextLine();
                    Vehicle found = agency.findVehicle(inspectId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 5: agency.displayStats(); break;
                case 6: exit = true; break;
            }
        }
        scanner.close();
    }
}`
};

// ==========================================
// 2. LIVE VEHICLE FLEET EMULATOR STATE
// ==========================================
const FLEET_INVENTORY = [
    { id: "C001", brand: "Toyota", model: "Camry", type: "Car", baseRate: 50.00, hasInsurance: true, isRented: false },
    { id: "C002", brand: "Honda", model: "Civic", type: "Car", baseRate: 40.00, hasInsurance: false, isRented: false },
    { id: "C003", brand: "Tesla", model: "Model 3", type: "Car", baseRate: 85.00, hasInsurance: true, isRented: false },
    { id: "M001", brand: "Harley-Davidson", model: "Sportster", type: "Motorcycle", baseRate: 60.00, includesHelmet: true, isRented: false },
    { id: "M002", brand: "Kawasaki", model: "Ninja 400", type: "Motorcycle", baseRate: 35.00, includesHelmet: false, isRented: false },
    { id: "T001", brand: "Ford", model: "F-150", type: "Truck", baseRate: 75.00, cargoCapacity: 1.5, isRented: false },
    { id: "T002", brand: "Chevrolet", model: "Silverado", type: "Truck", baseRate: 80.00, cargoCapacity: 2.0, isRented: false },
    { id: "T003", brand: "Volvo", model: "Heavy Hauler", type: "Truck", baseRate: 250.00, cargoCapacity: 18.0, isRented: false }
];

// Calculate cost based on type-specific rules (emulates Java Polymorphism)
function calculateRentalCost(vehicle, days) {
    if (days <= 0) return 0;
    const baseCost = vehicle.baseRate * days;
    let surcharge = 0;
    
    if (vehicle.type === "Car" && vehicle.hasInsurance) {
        surcharge = 15.00 * days; // $15.00/day insurance
    } else if (vehicle.type === "Motorcycle" && vehicle.includesHelmet) {
        surcharge = 5.00 * days;  // $5.00/day helmet
    } else if (vehicle.type === "Truck") {
        surcharge = vehicle.cargoCapacity * 20.00 * days; // $20.00 per ton per day
    }
    return baseCost + surcharge;
}

// Render Fleet in UI
function renderFleet() {
    const container = document.getElementById("fleet-container");
    container.innerHTML = "";
    
    FLEET_INVENTORY.forEach(v => {
        const card = document.createElement("div");
        card.className = "fleet-card glass";
        
        let surchargeText = "";
        if (v.type === "Car") {
            surchargeText = v.hasInsurance ? "Insurance Surcharge: +$15.00/day" : "Insurance Surcharge: None";
        } else if (v.type === "Motorcycle") {
            surchargeText = v.includesHelmet ? "Helmet Rental: +$5.00/day" : "Helmet Rental: None";
        } else if (v.type === "Truck") {
            surchargeText = `Cargo Capacity: ${v.cargoCapacity.toFixed(1)} Tons (+$${(v.cargoCapacity * 20.0).toFixed(2)}/day)`;
        }

        card.innerHTML = `
            <div class="fleet-card-header">
                <div>
                    <h3 class="vehicle-title">${v.brand} ${v.model}</h3>
                    <div class="vehicle-id">ID: ${v.id}</div>
                </div>
                <span class="category-tag ${v.type.toLowerCase()}">${v.type}</span>
            </div>
            <div class="fleet-card-body">
                <div class="rate-display">
                    <span class="rate-amount">$${v.baseRate.toFixed(2)}</span>
                    <span class="rate-period">/ day</span>
                </div>
                <div class="surcharge-info">${surchargeText}</div>
            </div>
            <div class="fleet-card-footer">
                <span class="status-badge ${v.isRented ? 'rented' : 'available'}">${v.isRented ? 'Rented' : 'Available'}</span>
                <button class="rent-action-btn ${v.isRented ? 'return' : 'rent'}" data-id="${v.id}">
                    ${v.isRented ? 'Return' : 'Rent Now'}
                </button>
            </div>
        `;
        container.appendChild(card);
    });

    // Rebind rent/return buttons
    document.querySelectorAll(".rent-action-btn").forEach(btn => {
        btn.addEventListener("click", handleRentalAction);
    });

    updateDashboard();
}

// Update the Metrics Dashboard
function updateDashboard() {
    const total = FLEET_INVENTORY.length;
    const rented = FLEET_INVENTORY.filter(v => v.isRented).length;
    const available = total - rented;
    const potentialRevenue = FLEET_INVENTORY.reduce((sum, v) => sum + v.baseRate, 0);

    document.getElementById("stat-total").innerText = total;
    document.getElementById("stat-rented").innerText = rented;
    document.getElementById("stat-available").innerText = available;
    document.getElementById("stat-revenue").innerText = `$${potentialRevenue.toFixed(2)}`;
}

// Handle clicking rent or return buttons
let selectedVehicleForRent = null;
function handleRentalAction(e) {
    const id = e.target.getAttribute("data-id");
    const vehicle = FLEET_INVENTORY.find(v => v.id === id);

    if (vehicle.isRented) {
        // Return vehicle directly
        vehicle.isRented = false;
        renderFleet();
    } else {
        // Open renting dialog
        selectedVehicleForRent = vehicle;
        document.getElementById("modal-vehicle-title").innerText = `${vehicle.brand} ${vehicle.model}`;
        document.getElementById("modal-vehicle-id").innerText = `ID: ${vehicle.id}`;
        document.getElementById("modal-vehicle-rate").innerText = `Base Rate: $${vehicle.baseRate.toFixed(2)} / day`;
        
        let detailStr = "";
        if (vehicle.type === "Car") detailStr = vehicle.hasInsurance ? "Car optioned with collision insurance coverage." : "Car optioned without insurance coverage.";
        if (vehicle.type === "Motorcycle") detailStr = vehicle.includesHelmet ? "Includes protective helmet rental." : "Helmet not included in rental.";
        if (vehicle.type === "Truck") detailStr = `Includes heavy-haul cargo support up to ${vehicle.cargoCapacity} tons capacity.`;
        document.getElementById("modal-vehicle-details").innerText = detailStr;

        // Reset days field and recalculate
        document.getElementById("rental-days").value = 3;
        updateReceiptBreakdown();
        
        // Open modal
        document.getElementById("rental-modal").classList.add("active");
    }
}

// Calculate and show receipt preview
function updateReceiptBreakdown() {
    if (!selectedVehicleForRent) return;
    const days = parseInt(document.getElementById("rental-days").value) || 0;
    
    const baseCost = selectedVehicleForRent.baseRate * days;
    let surchargeRate = 0;
    let surchargeLabel = "";

    if (selectedVehicleForRent.type === "Car" && selectedVehicleForRent.hasInsurance) {
        surchargeRate = 15.00;
        surchargeLabel = "Collision Insurance Surcharge ($15.00/day)";
    } else if (selectedVehicleForRent.type === "Motorcycle" && selectedVehicleForRent.includesHelmet) {
        surchargeRate = 5.00;
        surchargeLabel = "Helmet Rental Surcharge ($5.00/day)";
    } else if (selectedVehicleForRent.type === "Truck") {
        surchargeRate = selectedVehicleForRent.cargoCapacity * 20.00;
        surchargeLabel = `Capacity Surcharge ($20.00 per ton = $${surchargeRate.toFixed(2)}/day)`;
    }

    const surchargeTotal = surchargeRate * days;
    const grandTotal = baseCost + surchargeTotal;

    const receiptDiv = document.getElementById("receipt-preview");
    receiptDiv.innerHTML = `
        <div class="receipt-row">
            <span>Base Rate (${days} days x $${selectedVehicleForRent.baseRate.toFixed(2)}):</span>
            <span>$${baseCost.toFixed(2)}</span>
        </div>
        ${surchargeRate > 0 ? `
        <div class="receipt-row">
            <span>${surchargeLabel}:</span>
            <span>$${surchargeTotal.toFixed(2)}</span>
        </div>` : ""}
        <div class="receipt-row total">
            <span>Estimated Total Cost:</span>
            <span>$${grandTotal.toFixed(2)}</span>
        </div>
    `;
}


// ==========================================
// 3. THREE.JS 3D HERO OBJECT BUILDER
// ==========================================
let scene, camera, renderer, controls;
let carGroup;
let headlightLeftLight, headlightRightLight;
let wheels = [];
let bodyPaintMaterials = []; // References to change car body colors

function init3D() {
    const container = document.getElementById("canvas-container");
    const loader = document.getElementById("loader");
    
    // Scene setup
    scene = new THREE.Scene();
    scene.background = null; // transparent background to blend with CSS gradient

    // Camera setup
    camera = new THREE.PerspectiveCamera(40, container.clientWidth / container.clientHeight, 0.1, 100);
    camera.position.set(5.5, 3.5, 7.5);

    // Renderer
    renderer = new THREE.WebGLRenderer({ antialias: true, alpha: true });
    renderer.setSize(container.clientWidth, container.clientHeight);
    renderer.setPixelRatio(Math.min(window.devicePixelRatio, 2));
    renderer.shadowMap.enabled = true;
    renderer.shadowMap.type = THREE.PCFSoftShadowMap;
    container.appendChild(renderer.domElement);

    // OrbitControls
    controls = new THREE.OrbitControls(camera, renderer.domElement);
    controls.enableDamping = true;
    controls.dampingFactor = 0.05;
    controls.maxPolarAngle = Math.PI / 2 - 0.05; // Prevent camera going below floor
    controls.minDistance = 3.5;
    controls.maxDistance = 15;
    controls.target.set(0, 0.5, 0);

    // Ambient Lighting
    const ambientLight = new THREE.AmbientLight(0xffffff, 0.4);
    scene.add(ambientLight);

    // Directional Shadow Lighting (Sunlight)
    const dirLight = new THREE.DirectionalLight(0xffffff, 1.2);
    dirLight.position.set(5, 8, 5);
    dirLight.castShadow = true;
    dirLight.shadow.mapSize.width = 1024;
    dirLight.shadow.mapSize.height = 1024;
    dirLight.shadow.bias = -0.0005;
    scene.add(dirLight);

    // Fill Light (Backlight)
    const backLight = new THREE.DirectionalLight(0x7090ff, 0.6);
    backLight.position.set(-5, 3, -5);
    scene.add(backLight);

    // Floor Grid / Shadow Plane
    const shadowGeo = new THREE.PlaneGeometry(20, 20);
    const shadowMat = new THREE.ShadowMaterial({ opacity: 0.4 });
    const floor = new THREE.Mesh(shadowGeo, shadowMat);
    floor.rotation.x = -Math.PI / 2;
    floor.receiveShadow = true;
    scene.add(floor);

    // Floor Grid Helper for visual anchors
    const gridHelper = new THREE.GridHelper(20, 20, 0x555555, 0x222222);
    gridHelper.position.y = -0.01;
    scene.add(gridHelper);

    // BUILD THE PROCEDURAL 3D SPORTS CAR
    buildSportsCar();

    // Hide Loader
    if (loader) loader.style.display = "none";

    // Handle Window Resize
    window.addEventListener("resize", onWindowResize);
    
    // Begin Animation Loop
    animate();
}

function buildSportsCar() {
    carGroup = new THREE.Group();
    carGroup.position.set(0, 0, 0);
    scene.add(carGroup);

    // 3D Metallic Paint Material
    const paintColor = 0xd32f2f; // Crimson Red
    const paintMaterial = new THREE.MeshStandardMaterial({
        color: paintColor,
        roughness: 0.1,
        metalness: 0.85,
        clearcoat: 1.0,
        clearcoatRoughness: 0.1
    });
    bodyPaintMaterials.push(paintMaterial);

    const metalMaterial = new THREE.MeshStandardMaterial({
        color: 0xcccccc,
        roughness: 0.2,
        metalness: 0.9
    });

    const darkPlasticMaterial = new THREE.MeshStandardMaterial({
        color: 0x1a1a1a,
        roughness: 0.7,
        metalness: 0.2
    });

    const rubberMaterial = new THREE.MeshStandardMaterial({
        color: 0x242424,
        roughness: 0.8,
        metalness: 0.1
    });

    const glassMaterial = new THREE.MeshStandardMaterial({
        color: 0x111b24,
        roughness: 0.05,
        metalness: 0.9,
        transparent: true,
        opacity: 0.75
    });

    // 1. Car Base Chassis
    const chassisGeo = new THREE.BoxGeometry(3.6, 0.15, 1.7);
    const chassis = new THREE.Mesh(chassisGeo, darkPlasticMaterial);
    chassis.position.y = 0.18;
    chassis.castShadow = true;
    chassis.receiveShadow = true;
    carGroup.add(chassis);

    // 2. Lower Main Body
    const lowerBodyGeo = new THREE.BoxGeometry(3.5, 0.5, 1.68);
    const lowerBody = new THREE.Mesh(lowerBodyGeo, paintMaterial);
    lowerBody.position.y = 0.45;
    lowerBody.castShadow = true;
    lowerBody.receiveShadow = true;
    carGroup.add(lowerBody);

    // 3. Slanted Front Hood / Nose
    const frontHoodGeo = new THREE.BoxGeometry(1.0, 0.35, 1.64);
    const frontHood = new THREE.Mesh(frontHoodGeo, paintMaterial);
    frontHood.position.set(1.25, 0.42, 0);
    frontHood.rotation.z = -0.15; // Slant forward
    frontHood.castShadow = true;
    carGroup.add(frontHood);

    // 4. Slanted Rear Tail
    const rearTailGeo = new THREE.BoxGeometry(0.8, 0.35, 1.64);
    const rearTail = new THREE.Mesh(rearTailGeo, paintMaterial);
    rearTail.position.set(-1.35, 0.42, 0);
    rearTail.rotation.z = 0.15; // Slant backward
    rearTail.castShadow = true;
    carGroup.add(rearTail);

    // 5. Cabin Glass & Pillars
    const cabinGeo = new THREE.BoxGeometry(1.6, 0.6, 1.45);
    const cabin = new THREE.Mesh(cabinGeo, glassMaterial);
    cabin.position.set(-0.15, 0.85, 0);
    cabin.castShadow = true;
    carGroup.add(cabin);

    // 6. Roof (Body Paint)
    const roofGeo = new THREE.BoxGeometry(1.4, 0.05, 1.35);
    const roof = new THREE.Mesh(roofGeo, paintMaterial);
    roof.position.set(-0.15, 1.15, 0);
    roof.castShadow = true;
    carGroup.add(roof);

    // 7. Spoiler Wing
    const spoilerPostGeo = new THREE.BoxGeometry(0.08, 0.25, 1.2);
    const spoilerPosts = new THREE.Mesh(spoilerPostGeo, darkPlasticMaterial);
    spoilerPosts.position.set(-1.6, 0.65, 0);
    spoilerPosts.castShadow = true;
    carGroup.add(spoilerPosts);

    const spoilerGeo = new THREE.BoxGeometry(0.3, 0.05, 1.6);
    const spoiler = new THREE.Mesh(spoilerGeo, paintMaterial);
    spoiler.position.set(-1.6, 0.78, 0);
    spoiler.rotation.z = -0.1;
    spoiler.castShadow = true;
    carGroup.add(spoiler);

    // 8. Headlights (White glow meshes)
    const headlightGeo = new THREE.BoxGeometry(0.08, 0.12, 0.25);
    const headlightMat = new THREE.MeshStandardMaterial({
        color: 0xffffff,
        emissive: 0xfffcd3,
        emissiveIntensity: 1.5,
        roughness: 0.1
    });

    const headlightLeft = new THREE.Mesh(headlightGeo, headlightMat);
    headlightLeft.position.set(1.75, 0.42, 0.55);
    headlightLeft.rotation.y = 0.15;
    carGroup.add(headlightLeft);

    const headlightRight = headlightLeft.clone();
    headlightRight.position.z = -0.55;
    headlightRight.rotation.y = -0.15;
    carGroup.add(headlightRight);

    // Headlight SpotLights (Actual dynamic lights)
    headlightLeftLight = new THREE.PointLight(0xfffcd3, 2.5, 6);
    headlightLeftLight.position.set(1.9, 0.42, 0.55);
    headlightLeftLight.castShadow = true;
    carGroup.add(headlightLeftLight);

    headlightRightLight = headlightLeftLight.clone();
    headlightRightLight.position.z = -0.55;
    carGroup.add(headlightRightLight);

    // 9. Tail Lights (Red glow meshes)
    const tailLightGeo = new THREE.BoxGeometry(0.05, 0.08, 0.45);
    const tailLightMat = new THREE.MeshStandardMaterial({
        color: 0xff0000,
        emissive: 0xff0000,
        emissiveIntensity: 1.0
    });
    
    const tailLightL = new THREE.Mesh(tailLightGeo, tailLightMat);
    tailLightL.position.set(-1.75, 0.45, 0.48);
    carGroup.add(tailLightL);

    const tailLightR = tailLightL.clone();
    tailLightR.position.z = -0.48;
    carGroup.add(tailLightR);

    // 10. Wheels (Four Assemblies)
    const wheelGeo = new THREE.CylinderGeometry(0.38, 0.38, 0.28, 24);
    wheelGeo.rotateX(Math.PI / 2); // Rotate cylinder flat
    
    const rimGeo = new THREE.CylinderGeometry(0.24, 0.24, 0.3, 16);
    rimGeo.rotateX(Math.PI / 2);

    const wheelPositions = [
        { x: 1.0, z: 0.85 },   // Front Left
        { x: 1.0, z: -0.85 },  // Front Right
        { x: -1.0, z: 0.85 },  // Rear Left
        { x: -1.0, z: -0.85 }  // Rear Right
    ];

    wheelPositions.forEach((pos, idx) => {
        const wheelAssembly = new THREE.Group();
        wheelAssembly.position.set(pos.x, 0.38, pos.z);
        
        // Tire
        const tire = new THREE.Mesh(wheelGeo, rubberMaterial);
        tire.castShadow = true;
        wheelAssembly.add(tire);
        
        // Rim
        const rim = new THREE.Mesh(rimGeo, metalMaterial);
        wheelAssembly.add(rim);

        // Rim spokes (detail visual)
        const spokeGeo = new THREE.BoxGeometry(0.06, 0.42, 0.06);
        for(let r = 0; r < 4; r++) {
            const spoke = new THREE.Mesh(spokeGeo, metalMaterial);
            spoke.rotation.z = (r * Math.PI) / 4;
            wheelAssembly.add(spoke);
        }

        carGroup.add(wheelAssembly);
        wheels.push(wheelAssembly); // Save references to rotate wheels in render loop
    });
}

function onWindowResize() {
    const container = document.getElementById("canvas-container");
    camera.aspect = container.clientWidth / container.clientHeight;
    camera.updateProjectionMatrix();
    renderer.setSize(container.clientWidth, container.clientHeight);
}

// Interactive customizer updates
function setBodyColor(hexColor) {
    bodyPaintMaterials.forEach(mat => {
        mat.color.set(hexColor);
    });
}

function toggleHeadlights(isOn) {
    if (isOn) {
        headlightLeftLight.intensity = 2.5;
        headlightRightLight.intensity = 2.5;
    } else {
        headlightLeftLight.intensity = 0.0;
        headlightRightLight.intensity = 0.0;
    }
}

// 3D Animation Render loop
let angle = 0;
function animate() {
    requestAnimationFrame(animate);

    // Rotate Wheels slightly to simulate movement
    wheels.forEach(wheel => {
        wheel.rotation.z -= 0.02;
    });

    // Auto rotate the car group slowly if orbit controls are not being active
    if (!controls.state === -1) {
        carGroup.rotation.y += 0.003;
    } else {
        // Slowly oscillate car rotation over time
        angle += 0.003;
        carGroup.rotation.y = Math.sin(angle) * 0.25;
        // Make the body bob slightly up and down
        carGroup.position.y = Math.sin(angle * 2) * 0.03;
    }

    controls.update();
    renderer.render(scene, camera);
}


// ==========================================
// 4. DOM EVENTS AND CONTROLLERS BINDING
// ==========================================
document.addEventListener("DOMContentLoaded", () => {
    // 1. Initialise Fleet Emulator
    renderFleet();
    
    // 2. Initialise 3D Three.js Engine
    init3D();

    // 3. Color Customizer Buttons
    document.querySelectorAll(".color-btn").forEach(btn => {
        btn.addEventListener("click", (e) => {
            document.querySelectorAll(".color-btn").forEach(b => b.classList.remove("active"));
            e.target.classList.add("active");
            
            const colorHex = e.target.getAttribute("data-color");
            setBodyColor(colorHex);
        });
    });

    // 4. Headlight Toggle Switch
    const headlightSwitch = document.getElementById("headlight-switch");
    headlightSwitch.addEventListener("change", (e) => {
        toggleHeadlights(e.target.checked);
    });

    // 5. Code Browser Tab Selection
    const codeTabs = document.querySelectorAll(".tab-btn");
    const codeContent = document.getElementById("code-content");
    const displayFileName = document.getElementById("display-file-name");

    // Preload Vehicle.java on load
    codeContent.innerText = JAVA_CODE["Vehicle.java"];
    displayFileName.innerText = "Vehicle.java";

    codeTabs.forEach(tab => {
        tab.addEventListener("click", (e) => {
            codeTabs.forEach(t => t.classList.remove("active"));
            
            // Get selected button (handling clicks on meta text nested inside)
            const targetButton = e.target.closest(".tab-btn");
            targetButton.classList.add("active");

            const fileName = targetButton.getAttribute("data-file");
            codeContent.innerText = JAVA_CODE[fileName];
            displayFileName.innerText = fileName;
        });
    });

    // 6. Copy Code Button
    document.getElementById("copy-code-btn").addEventListener("click", () => {
        const text = codeContent.innerText;
        navigator.clipboard.writeText(text).then(() => {
            const btn = document.getElementById("copy-code-btn");
            btn.innerText = "Copied!";
            setTimeout(() => {
                btn.innerText = "Copy Code";
            }, 2000);
        });
    });

    // 7. Modal Closing
    const modal = document.getElementById("rental-modal");
    document.getElementById("close-modal").addEventListener("click", () => {
        modal.classList.remove("active");
        selectedVehicleForRent = null;
    });

    // Update receipt breakdown when typing duration
    document.getElementById("rental-days").addEventListener("input", updateReceiptBreakdown);

    // Confirming rental form
    document.getElementById("rental-form").addEventListener("submit", (e) => {
        e.preventDefault();
        if (selectedVehicleForRent) {
            selectedVehicleForRent.isRented = true;
            modal.classList.remove("active");
            renderFleet();
            selectedVehicleForRent = null;
        }
    });

    // Close modal if user clicks outside content card
    window.addEventListener("click", (e) => {
        if (e.target === modal) {
            modal.classList.remove("active");
            selectedVehicleForRent = null;
        }
    });
});
