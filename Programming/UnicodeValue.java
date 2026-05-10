import java.util.Scanner;
public class UnicodeValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>=65 && n<=127) {
			System.out.println((char)n);
		}else {
			System.out.println("Invalid");
		}

	}

}
