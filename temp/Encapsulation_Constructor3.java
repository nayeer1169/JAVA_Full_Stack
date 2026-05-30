import java.util.Scanner;

class Employee{
	private int eId;
	private String eName;
	private double eSal;
	//default constructor
	public Employee() {
	
	}
	//Parameterized constructor
	public Employee(int eId, String eName,double eSal) {
		this.eId = eId;
		this.eName = eName;
		this.eSal = eSal;
	}
	
	public void setEid(int eId) {
		this.eId=eId;
	}
	public void setEname(String eName) {
		this.eName=eName;
	}
	public void setEsal(double eSal) {
		this.eSal = eSal;
	}
	
	public int getEid() {
		return eId;
	}
	public String getEname() {
		return eName;
	}
	public double getEsal() {
		return eSal;
	}
}


public class Encapsulation_Constructor3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of employees:");
		int n = sc.nextInt();
		sc.nextLine();
		
		Employee e = null;
		Employee[] empArr = new Employee[n];
		
		for(int i=0;i<empArr.length;i++) {
			System.out.println("Enter the employee details: ");
			String empDetails = sc.nextLine();
			
			String[] ar = empDetails.split(",");
			
			e = new Employee(Integer.parseInt(ar[0]),ar[1],Double.parseDouble(ar[2]));
			empArr[i] = e;
		}
		for(int i=0;i<empArr.length;i++) {
			System.out.println(empArr[i].getEid());
			System.out.println(empArr[i].getEname());
			System.out.println(empArr[i].getEsal());
		}
		
		

	}

}
 