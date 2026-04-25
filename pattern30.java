//1
//3*2
//6*5*4
//10*9*8*7
//15*14*13*12*11

public class pattern30 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		
		
		for(int i=1;i<=n;i++) {
			int count=i*(i+1)/2;
			for(int j=1;j<=i;j++) {
				System.out.print(count--);
				if(j<i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}
}