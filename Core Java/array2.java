//2d array
import java.util.Scanner;
public class array2 {
	static void createArray2(int n,int m){
		Scanner sc = new Scanner(System.in);
		int [][]a=new int[n][m];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.println("enter the element:- ");
				a[i][j]=sc.nextInt();
			}
			System.out.println(" ");
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of classroom:- ");
		int n = sc.nextInt();
		System.out.println("Enter no. of students:- ");
		int m = sc.nextInt();
		
		
		createArray2(n,m);

	}

}
