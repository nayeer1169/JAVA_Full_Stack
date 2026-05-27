import java.util.Scanner;
public class String1 {

	public static void main(java.lang.String[] args) {
		Scanner sc = new Scanner(System.in);
		 String s = sc.nextLine();
		 int count=1;
		 for(int i=0;i<s.length();i++) {
			 if(s.charAt(i)==' ') {
				 count++;
			 }
		 }
		 System.out.println(count);
		 

	}

}
