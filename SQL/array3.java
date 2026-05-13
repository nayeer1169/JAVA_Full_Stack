//array3
import java.util.Scanner;
public class array3 {
	static void createArray3(int n,int m,int o) {
		Scanner sc = new Scanner(System.in);
		int a[][][] = new int[n][m][o];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				for(int k=0;k<a[i][j].length;k++) {
					System.out.println("Enter the no of school "+i+" class"+j+" Student"+k);
					a[i][j][k]=sc.nextInt();
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				for(int k=0;k<a[i][j].length;k++) {
					System.out.print(a[i][j][k]+" ");
				}
				System.out.println(" ");
			}
			System.out.println("-------");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of school: ");
		int n = sc.nextInt();
		System.out.println("Enter no of class: ");
		int m = sc.nextInt();
		System.out.println("Enter no of students: ");
		int o = sc.nextInt();
		
		createArray3(n,m,o);

	}

}
