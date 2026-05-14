//INPUT
//10
//20
//30

//OUTPUT
//30
//40
//50

import java.util.Scanner;

public class SumOfPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int sum1 = a+b;
		int sum2 = a+c;
		int sum3 = b+c;
		
		System.out.println("Sum1 = "+sum1);
		System.out.println("Sum2 = "+sum2);
		System.out.println("Sum3 = "+sum3);


	}

}
