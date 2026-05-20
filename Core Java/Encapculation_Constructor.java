class Customer{
	private int cId;
	private String cName;
	private long cNum;
	//Zero Parameterized constructor
	public Customer() {
		cId=1;
		cName="Shreyas";
		cNum=1234567899l;
	}
	//Parameterized constructor
	public Customer(int cId, String cName,long cNum) {
		this.cId = cId;
		this.cName = cName;
		this.cNum = cNum;
	}
	
	public int getCid() {
		return cId;
	}
	public String getCname() {
		return cName;
	}
	public long getCnum() {
		return cNum;
	}
}


public class Encapculation_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c1 = new Customer();
		System.out.println(c1.getCid());
		System.out.println(c1.getCname());
		System.out.println(c1.getCnum());
		
		Customer c2 = new Customer(2,"Iyer",9876543211l);
		System.out.println(c2.getCid());
		System.out.println(c2.getCname());
		System.out.println(c2.getCnum());
		
		

	}

}
 