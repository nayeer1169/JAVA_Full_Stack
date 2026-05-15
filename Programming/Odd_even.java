import java.util.Scanner;
public class Odd_even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n %2 ==0) {
			System.out.print("Even");
		}else{
			System.out.println("Odd");
		}

	}

}
