class Plane {

    public void takeOff() {
        System.out.println("Plane is taking off");
    }

    public void fly() {
        System.out.println("Plane is flying");
    }

    public void land() {
        System.out.println("Plane is landing");
    }
}

class CargoPlane extends Plane {

    @Override
    public void takeOff() {
        System.out.println("Cargo Plane is taking off from long runway");
    }

    @Override
    public void fly() {
        System.out.println("Cargo Plane is flying at low height");
    }

    @Override
    public void land() {
        System.out.println("Cargo Plane is landing on long runway");
    }

    public void carryCargo() {
        System.out.println("Cargo Plane is carrying cargo");
    }
}

class PassengerPlane extends Plane {

    @Override
    public void takeOff() {
        System.out.println("Passenger Plane is taking off from medium runway");
    }

    @Override
    public void fly() {
        System.out.println("Passenger Plane is flying at medium height");
    }

    @Override
    public void land() {
        System.out.println("Passenger Plane is landing on medium runway");
    }

    public void carryPassengers() {
        System.out.println("Passenger Plane is carrying passengers");
    }
}

class FighterPlane extends Plane {

    @Override
    public void takeOff() {
        System.out.println("Fighter Plane is taking off from small runway");
    }

    @Override
    public void fly() {
        System.out.println("Fighter Plane is flying at great height");
    }

    @Override
    public void land() {
        System.out.println("Fighter Plane is landing on small runway");
    }

    public void carryWeapons() {
        System.out.println("Fighter Plane is carrying weapons");
    }
}

class Airport {

    public void permit(Plane ref) {
        ref.takeOff();
        ref.fly();
        ref.land();
        System.out.println();
    }
}

public class Polymorphism {

    public static void main(String[] args) {

        CargoPlane cp = new CargoPlane();
        PassengerPlane pp = new PassengerPlane();
        FighterPlane fp = new FighterPlane();

        Airport a = new Airport();

        a.permit(cp);
        a.permit(pp);
        a.permit(fp);
    }
}