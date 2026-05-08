
public class pattern35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				if(i==1 || j==n || i==j) {
				System.out.print(j);
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
	}

}
