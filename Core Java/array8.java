//find the occurence of kth element
import java.util.Scanner;

public class array8 {
	public static int kOccurence(int[] a , int k){
		int count = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==k) {
				count++;
			}
		}
		return count;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		int res = kOccurence(a,k);
		System.out.print(res);

	}

}
