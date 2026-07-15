import java.util.Scanner;

abstract class Student9999{
	float percentage;
	
	abstract public void acceptInput();
	abstract public void calculatePercentage();
	
	public void displayPercentage() {
		System.out.println("Percentage : "+percentage);
	}
}

class Engineering9999 extends Student9999{
	private float marks;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineering student marks ");
		marks = sc.nextFloat();
	}
	@Override
	public void calculatePercentage() {
		percentage = (marks/500) * 100;
	}
}

class Medical9999 extends Student9999{
	private float marks;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Medical student marks ");
		marks = sc.nextFloat();
	}
	@Override
	public void calculatePercentage() {
		percentage = (marks/500) * 100;
	}
}

class Commerce9999 extends Student9999{
	private float marks;
	
	@Override
	public void acceptInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter commerce student marks ");
		marks = sc.nextFloat();
	}
	@Override
	public void calculatePercentage() {
		percentage = (marks/500) * 100;
	}
}

class College9999{
	static void permit(Student9999 ref) {
		ref.acceptInput();
		ref.calculatePercentage();
		ref.displayPercentage();
	}
}

public class Abstraction6 {

	public static void main(String[] args) {
		Engineering9999 e = new Engineering9999();
		Medical9999 m = new Medical9999();
		Commerce9999 c = new Commerce9999();
		
		College9999 cg = new College9999();
		cg.permit(e);
		cg.permit(m);
		cg.permit(c);

	}

}
