import java.util.Scanner;

abstract class Shape {
    protected float area;

    public abstract void acceptInput();
    public abstract void calculateArea();

    public void displayArea() {
        System.out.println("Area = " + area);
    }
}

class Square extends Shape {
    private float side;

    @Override
    public void acceptInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side of square: ");
        side = sc.nextFloat();
    }

    @Override
    public void calculateArea() {
        area = side * side;
    }
}

class Rectangle extends Shape {
    private float length;
    private float breadth;

    @Override
    public void acceptInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        length = sc.nextFloat();

        System.out.print("Enter breadth of rectangle: ");
        breadth = sc.nextFloat();
    }

    @Override
    public void calculateArea() {
        area = length * breadth;
    }
}

class Circle extends Shape {
    private float radius;

    @Override
    public void acceptInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        radius = sc.nextFloat();
    }

    @Override
    public void calculateArea() {
        area = 3.14f * radius * radius;
    }
}

class Geometry {
    public void operations(Shape ref) {
        ref.acceptInput();
        ref.calculateArea();
        ref.displayArea();
    }
}

public class OOPs1 {
    public static void main(String[] args) {

        Square s = new Square();
        Rectangle r = new Rectangle();
        Circle c = new Circle();

        Geometry g = new Geometry();

        g.operations(s);
        g.operations(r);
        g.operations(c);
    }
}