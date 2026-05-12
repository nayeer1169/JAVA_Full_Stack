import java.util.Scanner;

public class Two_digit_or_not {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>=10 && n<=99) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
