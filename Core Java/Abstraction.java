abstract class Plane56789{
	abstract void takeOff();
	abstract void fly();
	abstract void land();
}

class CargoPlane56789 extends Plane56789{
	@Override
	void takeOff() {
		System.out.println("CargoPlane is taking off.");
	}
	@Override
	void fly() {
		System.out.println("CargoPlane is flying at low heights");
	}
	@Override
	void land() {
		System.out.println("CargoPlane is landing");
		System.out.println("-------------------------------------");
	}
}

class PassengerPlane56789 extends Plane56789{
	@Override
	void takeOff() {
		System.out.println("PassengerPlane is taking off.");
	}
	@Override
	void fly() {
		System.out.println("PassengerPlane is flying at medium heights");
	}
	@Override
	void land() {
		System.out.println("PassengerPlane is landing");
		System.out.println("-------------------------------------");
	}
}



class FighterPlane56789 extends Plane56789{
	@Override
	void takeOff() {
		System.out.println("FighterPlane is taking off.");
	}
	@Override
	void fly() {
		System.out.println("FighterPlane is flying at high heights");
	}
	@Override
	void land() {
		System.out.println("FighterPlane is landing");
		System.out.println("-------------------------------------");
	}
}

class Airport56789{
	static void permit(Plane56789 ref) {
		ref.takeOff();
		ref.fly();
		ref.land();
	}
}

public class Abstraction {

	public static void main(String[] args) {
		CargoPlane56789 cp = new CargoPlane56789();
		PassengerPlane56789 pp = new PassengerPlane56789();
		FighterPlane56789 fp = new FighterPlane56789();
		
		Airport56789.permit(cp);
		Airport56789.permit(pp);
		Airport56789.permit(fp);
		
	}

}
