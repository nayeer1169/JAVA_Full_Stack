//Mobile details 
import java.util.Scanner;

class Mobile1{
	private String brand;
	private String model;
	private int price;
	
	public Mobile1(){
		
	}
	
	public Mobile1(String brand , String model , int price) {
		this.brand=brand;
		this.model=model;
		this.price=price;
	}
	//we have already have setter (constructor )
	//but then also we are making just{ in case we want to change value manually
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//now method for the setters.
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
	
}

public class Encapsulation_Constructor4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of Mobile:");
		int n = sc.nextInt();
		sc.nextLine();
		
		Mobile1 m = null;
		Mobile1[] ar = new Mobile1[n];
		
		for(int i=0;i<ar.length;i++) {
			System.out.println("Enter the mobile details:");
			String mobileDetails = sc.nextLine();
			
			String[] ar2 = mobileDetails.split(",");
			m = new Mobile1(ar2[0],ar2[1],Integer.parseInt(ar2[2]));
			ar[i] = m; 	
		}
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i].getBrand());
			System.out.println(ar[i].getModel());
			System.out.println(ar[i].getPrice());
		}
		
		
		
		
		

	}

}
