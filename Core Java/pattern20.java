//*
//* * *
//* * * * *
//* * * * * * * 
//* * * * * * * * * 

//formula here is 2*i-1 : 
//i   j   ->  2*i-1
//1   2       2*1-1
//2   3       2*2-1
//3   5       2*3-1
//4   7       2*4-1
//5   9       2*5-1

public class pattern20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		for (int i=1;i<=n;i++) {
			for(int j=1;j<=(2*i-1);j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}

	}

}
