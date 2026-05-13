//1d array
import java.util.Scanner;
public class array1 {
	static void createArray(int n){
		Scanner sc = new Scanner(System.in);
		int[] a =new int[n];
		System.out.println("Enter the element:-");
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array:- ");
		int n = sc.nextInt();
		
		createArray(n);

	}

}
