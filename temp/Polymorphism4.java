class Vehicle {

    public void start() {
        System.out.println("Vehicle is starting");
    }

    public void move() {
        System.out.println("Vehicle is moving");
    }

    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}

class Car extends Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts with key");
    }

    @Override
    public void move() {
        System.out.println("Car runs on road");
    }

    @Override
    public void stop() {
        System.out.println("Car stops using brakes");
    }
}

class Bike extends Vehicle {

    @Override
    public void start() {
        System.out.println("Bike starts with self-start");
    }

    @Override
    public void move() {
        System.out.println("Bike runs at medium speed");
    }

    @Override
    public void stop() {
        System.out.println("Bike stops using disc brakes");
    }
}

class Bus extends Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts with engine ignition");
    }

    @Override
    public void move() {
        System.out.println("Bus carries passengers");
    }

    @Override
    public void stop() {
        System.out.println("Bus stops at bus stop");
    }
}

class TrafficControl {

    public void allow(Vehicle ref) {
        ref.start();
        ref.move();
        ref.stop();
        System.out.println();
    }
}

public class Polymorphism4 {

    public static void main(String[] args) {

        Car c = new Car();
        Bike b = new Bike();
        Bus bs = new Bus();

        TrafficControl tc = new TrafficControl();

        tc.allow(c);
        tc.allow(b);
        tc.allow(bs);
    }
}