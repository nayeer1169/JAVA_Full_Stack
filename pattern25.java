//111112
//322222
//333334
//544444
//555556

public class pattern25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		for(int i=1;i<=n;i++) { 	
			if(i%2==0) {
				System.out.print(i+1);
			}
			for(int j=1;j<=n;j++) {
				System.out.print(i);
			}
			if(i%2!=0) {
				System.out.print(i+1);
			}
			System.out.println("");
		}

	}

}
