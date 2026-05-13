//objects inside array - mobile details
import java.util.Scanner;
public class array8 {
	

	public static void main(String[] args) {
		class MobileDetails{
			String brand;
			String model;
			double price;
			
		}
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MobileDetails m1 = null;
		MobileDetails a[]  = new MobileDetails[2]; 
		
		for(int i=0;i<a.length;i++) {
			m1 = new MobileDetails();
			System.out.println("Enter the Brand of mobile:");
			m1.brand=sc.next();
			System.out.println("Enter the model of mobile:");
			m1.model=sc.next();
			System.out.println("Enter the price of mobile:");
			m1.price = sc.nextDouble();	
			a[i]=m1;
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].brand+" "+a[i].model+" "+a[i].price);
		}

	}

}
