import java.util.Scanner;
public class array6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean a[]=new boolean[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextBoolean();
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}

	}

}
