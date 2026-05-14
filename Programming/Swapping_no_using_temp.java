import java.util.Scanner;
public class Swapping_no_using_temp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		//before logic
		System.out.println(a);
		System.out.println(b);
		int temp = 0;
		temp = a;
		a=b;
		b=temp;
		//after logic
		System.out.println(a);
		System.out.println(b);
				

	}

}
