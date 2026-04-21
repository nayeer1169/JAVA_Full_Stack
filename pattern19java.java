//
//1
//123
//12345
//1234567
//123456789

//here i have done when n=9 but same output we have to give if n=5 solved in pattern21.java


public class pattern19java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		for(int i=1;i<=n;i=i+2) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println("");
		}

	}

}
