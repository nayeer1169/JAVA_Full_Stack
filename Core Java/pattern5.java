/*
 * * * * * 
 *       * 
 *       * 
 *       * 
 * * * * *  
*/
//same question (pattern 4) but here we will initialize int n = whatever is the required ones.
public class pattern5 {

	public static void main(String[] args) {
		int n = 4;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==1 || i==n || j==1 || j==n) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}

	}

}
