
class Mobile{
	private String brand;
	private String model;
	private double price;
	private int ram;
	//non parameterized constructor
	public Mobile(){
		brand = "samsung";
		model = "s24_Ultra";
		price = 79999.99;
		ram = 12;
	}
	//parameterized constructor
	public Mobile(String brand , String model , double price , int ram) {
		this.brand=brand;
		this.model=model;
		this.price=price;
		this.ram=ram;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public double getPrice() {
		return price;
	}
	public int getRam() {
		return ram;
	}
}

public class Encapsulation_Constructor2 {
	public static void main(String[] args) {
		Mobile m2 = new Mobile();
		System.out.println(m2.getBrand());
		System.out.println(m2.getModel());
		System.out.println(m2.getPrice());
		System.out.println(m2.getRam());
		
		Mobile m1 = new Mobile("Apple","17promax",129999.99,12);
		System.out.println(m1.getBrand());
		System.out.println(m1.getModel());
		System.out.println(m1.getPrice());
		System.out.println(m1.getRam());
		
		
		
		
	}
}
