import java.util.Scanner;

abstract class Shape3456{
	float area;
	
	abstract public void acceptInput();
	abstract public void calcArea();
	
	public void dispArea() {
		System.out.println(area);
	}
}

class Square3456 extends Shape3456{
	private float side;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the side");
		side=sc.nextFloat();
	}
	@Override
	public void calcArea(){
		area = side*side;
	}
}

class Rectangle3456 extends Shape3456{
	private float length;
	private float breadth;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length ");
		length = sc.nextFloat();
		System.out.println("Enter the breadth ");
		breadth = sc.nextFloat();
	}
	@Override
	public void calcArea() {
		area = length*breadth;
	}
}

class Circle3456 extends Shape3456{
	private float radius;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius ");
		radius = sc.nextFloat();
	}
	@Override
	public void calcArea() {
		area = 3.141f*radius*radius;
	}
}

class Geometry3456{
	public void permit(Shape3456 ref) {
		ref.acceptInput();
		ref.calcArea();
		ref.dispArea();
	}
}

public class Abstraction2 {

	public static void main(String[] args) {
		Square3456 s = new Square3456();
		Rectangle3456 r = new Rectangle3456();
		Circle3456 c = new Circle3456();
		
		Geometry3456 g = new Geometry3456();
		g.permit(s);
		g.permit(r);
		g.permit(c);
	}

}
