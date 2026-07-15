import java.util.Scanner;

abstract class Employee9999{
	float salary;
	
	abstract public void acceptInput();
	abstract public void calculateSalary();
	
	public void displaySalary() {
		System.out.println("Salary = "+salary);
		System.out.println("-------------------");
	}
}

class Developer9999 extends Employee9999{
	private float basicSalary;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Developer Basic Salary");
		basicSalary = sc.nextFloat();
	}
	@Override 
	public void calculateSalary() {
		salary = basicSalary + (basicSalary*0.20f);
	}
}

class Tester9999 extends Employee9999{
	private float basicSalary;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tester Basic Salary");
		basicSalary = sc.nextFloat(); 
	}
	@Override
	public void calculateSalary() {
		salary = basicSalary + (basicSalary * 0.15f);
	}
}

class Manager9999 extends Employee9999{
	private float basicSalary;
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter manager basic salary ");
		basicSalary = sc.nextFloat();
	}
	@Override
	public void calculateSalary() {
		salary = basicSalary + (basicSalary * 0.30f);
	}
}

class Company9999{
	public void permit(Employee9999 ref) {
		ref.acceptInput();
		ref.calculateSalary();
		ref.displaySalary();
	}
}

public class Abstraction5 {

	public static void main(String[] args) {
		Developer9999 d = new Developer9999();
		Tester9999 t = new Tester9999();
		Manager9999 m = new Manager9999();
		
		Company9999 c = new Company9999(); 
		
		c.permit(d);
		c.permit(t);
		c.permit(m);
	}

}
