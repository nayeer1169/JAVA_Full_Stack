//1 2 3 4 5 
//2 3 4 5 6 
//3 4 5 6 7 
//4 5 6 7 8 
//5 6 7 8 9
public class pattern9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;     //if we change the number with 8
		for (int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
//				if(i+j-1<10) {
//					System.out.print(0);
//				}
				System.out.print(i+j-1+" ");
			}
			System.out.println();
		}

	}

}
