//A 
//C B 
//D E F 
//J I H G  
//K L M N O 

public class pattern34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		char ch='A';
		
		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				char chRev = (char)(ch+i-1);
				for(int j=1;j<=i;j++) {
					System.out.print(chRev-- +" ");
					ch++;
				}
				}else {
					for(int j=1;j<=i;j++) {
						System.out.print(ch++ +" ");
					}
			}
			
			System.out.println();
		}

	}

}
