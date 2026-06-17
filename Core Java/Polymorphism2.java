class Animal {

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps in kennel");
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("Cat drinks milk");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeps on sofa");
    }
}

class Lion extends Animal {

    @Override
    public void eat() {
        System.out.println("Lion hunts prey");
    }

    @Override
    public void sleep() {
        System.out.println("Lion sleeps in den");
    }
}

class Forest {

    public void allowAnimal(Animal a) {
        a.eat();
        a.sleep();
        System.out.println();
    }
}

public class Polymorphism2 {
    public static void main(String[] args) {

        Dog d = new Dog();
        Cat c = new Cat();
        Lion l = new Lion();

        Forest f = new Forest();

        f.allowAnimal(d);
        f.allowAnimal(c);
        f.allowAnimal(l);
    }
}