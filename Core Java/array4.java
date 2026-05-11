import java.util.Scanner;
public class array4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float a[]=new float[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextFloat();
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		

	}

}
