//1 
//2 2 
//3 3 3 
//4 4 4 4 
//5 5 5 5 5 
//4 4 4 4 
//3 3 3 
//2 2 
//1 


public class pattern26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =5;
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=i;j++) {
//				int count =1;
				System.out.print(i +" ");
			}
			
			System.out.println("");
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(n-i+" ");
			}
			System.out.println();
		}

	}

}
