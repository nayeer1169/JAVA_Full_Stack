import java.util.TreeSet;

class Customer111 implements Comparable<Customer111>{
	private int customerId;
	private String customerName;
	private String city;
	private Float accountBalance;
	private Long mobileNumber;
	
	public Customer111(int customerId, String customerName, String city, Float accountBalance, Long mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.city = city;
		this.accountBalance = accountBalance;
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public int compareTo(Customer111 c2) {
		Customer111 c1 = this;
		
		String city1 = c1.city;
		String city2 = c2.city;
		
		if(city1.equals(city2)) {
			String name1 = c1.customerName;
			String name2 = c2.customerName;
			
			if(name1.equals(name2)) {
				Float balance1 = c1.accountBalance;
				Float balance2 = c2.accountBalance;
				
				if(balance1.equals(balance2)) {
					Integer id1 = c1.customerId;
					Integer id2 = c2.customerId;
					
					return id1.compareTo(id2);
				}
				return balance1.compareTo(balance2);
				
			}
			return name1.compareTo(name2);
		}
		return city1.compareTo(city2);
	}
	
	@Override
	public String toString() {
		return "Customer ID : "+customerId+
			   "| Name : "+customerName+
			   "| City : "+city+
			   "| Balance : "+accountBalance+
			   "| Mobile : "+mobileNumber;
	}
	
	
	
}
public class comparable1 {

	public static void main(String[] args) {
		TreeSet<Customer111> customers = new TreeSet<Customer111>();
		
		Customer111 c1 = new Customer111(101, "Amitabh", "Delhi", 35000f, 1234567890l);
		Customer111 c2 = new Customer111(102, "Amitabh", "Delhi", 35000f, 2234567890l);
		Customer111 c3 = new Customer111(103, "Amitabh", "Delhi", 35000f, 3234567890l);
		Customer111 c4 = new Customer111(104, "Amitabh", "Delhi", 35000f, 4234567890l);
		Customer111 c5 = new Customer111(105, "Amitabh", "Delhi", 35000f, 5234567890l);
		Customer111 c6 = new Customer111(106, "Amitabh", "Delhi", 35000f, 6234567890l);
		Customer111 c7 = new Customer111(107, "Amitabh", "Delhi", 35000f, 7234567890l);
		
		customers.add(c7);
		customers.add(c4);
		customers.add(c2);
		customers.add(c6);
		customers.add(c1);
		customers.add(c3);
		customers.add(c5);
		
		System.out.println("Customer Details after sorting\n");
		
		for(Customer111 customer : customers) {
			System.out.println(customer);			
		}

	}

}
