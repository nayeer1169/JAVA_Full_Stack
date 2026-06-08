class Charger {

    private String brand;
    private float voltage;

    public Charger(String brand, float voltage) {
        this.brand = brand;
        this.voltage = voltage;
    }

    public String getBrand() {
        return brand;
    }

    public float getVoltage() {
        return voltage;
    }
}

class OS {

    private String name;
    private int size;

    public OS(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

class Mobile2 {

    // Composition (Tight Bound)
    OS os = new OS("Android", 4);

    // Aggregation (Loose Bound)
    public void hasCharger(Charger ch) {

        System.out.println("Charger Brand   : " + ch.getBrand());
        System.out.println("Charger Voltage : " + ch.getVoltage());
    }
}

public class Association2 {

    public static void main(String[] args) {

        Mobile2 m = new Mobile2();

        Charger ch = new Charger("Samsung", 45.5f);

        m.hasCharger(ch);

        System.out.println("\nOperating System Details");
        System.out.println("OS Name : " + m.os.getName());
        System.out.println("OS Size : " + m.os.getSize() + " GB");

        // Mobile lost
        m = null;

        System.out.println("\nCharger Still Exists");
        System.out.println("Brand   : " + ch.getBrand());
        System.out.println("Voltage : " + ch.getVoltage());
    }
}