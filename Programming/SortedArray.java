//sorted array of n integer. WAP to count the number of uniques elements
import java.util.Scanner;
public class SortedArray {
	public static int countUniques(int[] a){
		int count = 1;
		int UniqueCount = 0;
		for(int i=0;i<a.length-1;i++) 
		{
			if(a[i]==a[i+1]) {
				count++;
			}
			else {
				if(count == 1) {
					UniqueCount++;
				}
				count=1;
			}
		}
		if(count==1) {
			UniqueCount++;
		}
		return UniqueCount;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		
		int res = countUniques(a);
		System.out.print(res);

	}

}
