class Bike1 {

    private String brand;
    private int mileage;

    public Bike1(String brand, int mileage) {
        this.brand = brand;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public int getMileage() {
        return mileage;
    }
}

class Book {

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}

class Heart {

    private int weight;
    private int bpm;

    public Heart(int weight, int bpm) {
        this.weight = weight;
        this.bpm = bpm;
    }

    public int getWeight() {
        return weight;
    }

    public int getBpm() {
        return bpm;
    }
}

class Brain {

    private int weight;
    private String color;

    public Brain(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}

class Student {

    Heart heart = new Heart(300, 72);
    Brain brain = new Brain(1400, "Gray");

    public void hasBike(Bike1 bike) {
        System.out.println("\nBike Details");
        System.out.println("Brand   : " + bike.getBrand());
        System.out.println("Mileage : " + bike.getMileage());
    }

    public void hasBook(Book book) {
        System.out.println("\nBook Details");
        System.out.println("Name    : " + book.getName());
        System.out.println("Author  : " + book.getAuthor());
    }
}

public class Association {

    public static void main(String[] args) {

        Student s = new Student();

        Bike1 bike = new Bike1("Royal Enfield", 40);
        Book book = new Book("Core Java", "Cay S. Horstmann");

        s.hasBike(bike);
        s.hasBook(book);

        System.out.println("\nHeart Details");
        System.out.println("Weight : " + s.heart.getWeight() + " gm");
        System.out.println("BPM    : " + s.heart.getBpm());

        System.out.println("\nBrain Details");
        System.out.println("Weight : " + s.brain.getWeight() + " gm");
        System.out.println("Color  : " + s.brain.getColor());
    }
}