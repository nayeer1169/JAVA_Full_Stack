//objects inside array
import java.util.Scanner;
public class array7 {
	public static class Employee{
		int id;
		String name;
		double salary;
	}
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		Employee e1 = new Employee();
		Employee e1 = null;
//		System.out.println("Enter the number of employee");
		Employee a[] = new Employee[2];
		for(int i=0;i<a.length;i++) {
			e1 = new Employee();
			System.out.println("Enter the employee id:");
			e1.id = sc.nextInt();
			System.out.println("Enter the employee name:");
			e1.name = sc.next();
			System.out.println("Enter the employee salary:");
			e1.salary = sc.nextDouble();
			a[i]=e1;         //Pass by reference
			
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].id+" "+a[i].name+" "+a[i].salary);
		}

	}

}
