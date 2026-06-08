abstract class Bird{
	abstract public void eat();
	abstract public void fly();
}

abstract class Eagle extends Bird{
	@Override
	public void fly() {
		System.out.println("Eagle fly at high altitude: ");
	}
}

class SerpentEagle extends Eagle{
	@Override
	public void eat() {
		System.out.println("Serpent Eagle eats sankes.");
	}
	
	@Override
	public void fly() {
		System.out.println("Serpent eagle flies while hunting.");
	}
}

class GoldenEagle extends Eagle{
	@Override
	public void eat() {
		System.out.println("Golden eagle eat fish.");
	}
	@Override
	public void fly() {
		System.out.println("Golden eagle fly powerfully.");
	}
}

class Jungle{
	public void allowBirdToFly(Bird ref) {
		ref.fly();
		ref.eat();
	}
}

public class OOPs2 {
	public static void main(String[] args) {
		SerpentEagle se = new SerpentEagle();
		GoldenEagle ge = new GoldenEagle();
		
		Jungle j = new Jungle();
		
		j.allowBirdToFly(se);
		j.allowBirdToFly(ge);
		
	}

}
