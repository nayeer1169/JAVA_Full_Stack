//    1 
//   1 2 
//  1   3 
// 1     4 
//1 2 3 4 5 
//
public class pattern15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for(int i=1;i<=n;i++) {
			for(int k=1;k<=n-i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				if(i==n || j==1 || i==j) {
					System.out.print(j+" ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}

	}

}
