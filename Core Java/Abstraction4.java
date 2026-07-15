abstract class Animal5454{
	abstract void eat();
	abstract void sound();
	abstract void sleep();
}
class Dog5454 extends Animal5454{
	@Override
	void eat() {
		System.out.println("Dog eats bones ");
	}
	@Override
	void sound() {
		System.out.println("Dog barks");
	}
	@Override
	void sleep() {
		System.out.println("Dog sleeps");
		System.out.println("--------------------");
	}
}

class Cat5454 extends Animal5454{
	@Override
	void eat() {
		System.out.println("Cat eats fish ");
	}
	@Override
	void sound() {
		System.out.println("cat meows ");
	}
	@Override
	void sleep() {
		System.out.println("Cat sleeps ");
		System.out.println("--------------------");
	}
}
class Cow5454 extends Animal5454{
	@Override
	void eat() {
		System.out.println("Cow eats grass ");
	}
	@Override
	void sound() {
		System.out.println("Cow mooes ");
	}
	@Override
	void sleep() {
		System.out.println("Cow Sleep ");
		System.out.println("--------------------");
	}
}
class Zoo{
	static void allow(Animal5454 a) {
		a.eat();
		a.sound();
		a.sleep();
	}
}
public class Abstraction4 {

	public static void main(String[] args) {
		Dog5454 d = new Dog5454();
		Cat5454 c = new Cat5454();
		Cow5454 cw = new Cow5454();
		
		Zoo.allow(d);
		Zoo.allow(c);
		Zoo.allow(cw);
	}

}


































