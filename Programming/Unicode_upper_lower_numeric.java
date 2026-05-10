import java.util.Scanner;
public class Unicode_upper_lower_numeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>=65 && n<=90) {
			System.out.println("Uppercase");
		}else if(n>=97 && n<=122) {
			System.out.println("Lowercase");
		}else if(n>=48 && n<=57) {
			System.out.println("Numeric");
		}else {
			System.out.println("NOA");
		}

	}

}
