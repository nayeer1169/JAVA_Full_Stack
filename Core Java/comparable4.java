import java.util.TreeSet;

class AccountManagement implements Comparable<AccountManagement>{
	private int accountNumber;
	private String customerName;
	private String branch;
	private String accountType;
	private int balance;
	private long mobileNumber;
	
	public AccountManagement(int accountNumber, String customerName, String branch, String accountType,
			int balance, long mobileNumber) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.branch = branch;
		this.accountType = accountType;
		this.balance = balance;
		this.mobileNumber = mobileNumber;
	}
	
	@Override
	public int compareTo(AccountManagement a2) {
		AccountManagement a1 = this;
		
		String branch1 = a1.branch;		
		String branch2 = a2.branch;	
		
		if(branch1.equals(branch2)) {
			String accountType1 = a1.accountType;
			String accountType2 = a2.accountType;
			
			if(accountType1.equals(accountType2)) {
				Integer balance1 = a1.balance;
				Integer balance2 = a2.balance;
				
				if(balance1.equals(balance2)) {
					String customerName1 = a1.customerName; 
					String customerName2 = a2.customerName;
					
					if(customerName.equals(customerName2)) {
						Integer accountNumber1 = a1.accountNumber;
						Integer accountNumber2 = a2.accountNumber;
						
						return accountNumber1.compareTo(accountNumber2);
					}
					return customerName1.compareTo(customerName2);
					
				}
				return balance1.compareTo(balance2);
			}
			return accountType1.compareTo(accountType2);
		}
		return branch1.compareTo(branch2);
	}

	@Override
	public String toString() {
		return "AccountManagement [accountNumber=" + accountNumber + ", customerName=" + customerName + ", branch="
				+ branch + ", accountType=" + accountType + ", balance=" + balance + ", mobileNumber=" + mobileNumber
				+ "]";
	}
}

public class comparable4 {

	public static void main(String[] args) {
		
		TreeSet<AccountManagement> accounts = new TreeSet<AccountManagement>();
		
		AccountManagement a1 = new AccountManagement(3868, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a2 = new AccountManagement(1969, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a3 = new AccountManagement(3863, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a4 = new AccountManagement(3861, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a5 = new AccountManagement(3860, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a6 = new AccountManagement(3858, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		AccountManagement a7 = new AccountManagement(3828, "Nayeer" , "Hinoo" , "Current" , 300 , 6203264124l);
		
		accounts.add(a7);
		accounts.add(a2);
		accounts.add(a4);
		accounts.add(a3);
		accounts.add(a1);
		accounts.add(a6);
		accounts.add(a5);
		
		System.out.println("Account Details in sorted order \n");
		
		for(AccountManagement account : accounts) {
			System.out.println(account);
		}
	}

}
