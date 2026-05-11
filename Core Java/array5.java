import java.util.Scanner;
public class array5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char a[]=new char[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.next().charAt(0);
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
