import java.util.Scanner;
public class Swapping_Two_no {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//before swapping
		System.out.println(n);
		System.out.println(m);
		//logic
		n=n+m;
		m=n-m;
		n=n-m;
		System.out.println(n);
		System.out.println(m);
	}

}
