//*
//* * *
//* * * * *
//* * * * * * * 
//* * * * * * * * * 

//here i have done when n=9 but same output we have to give if n=5 solved in pattern20.java

public class pattern18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		for(int i=1;i<=n;i=i+2) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}

	}

}
