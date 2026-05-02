//1
//12
//1 3
//1  4
//12345



public class pattern16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stubj++
		int n=5;
		for (int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(j==1 || i==n || i==j) {
					System.out.print(j+" ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
		

	}

}
