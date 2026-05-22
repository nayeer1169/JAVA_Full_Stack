
class BankAccount{
	private int bal;
	
	void setData(int data){
		if(data<0) {
			System.out.println("Invalid Input");
		}
		else {
			bal = data;
		}
	}
	int getData(){
		return bal;
	}
}
public class Encapsulation1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount sbi = new BankAccount();
		sbi.setData(1000);
		System.out.println(sbi.getData());
		

	}

}
