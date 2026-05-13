//array using object - crime case database

import java.util.Scanner;

public class array10 {

	public static void main(String[] args) {
		class crimeCase{
			int caseId;
			String criminalName;
			String crimeType;
			int yearsPunishment;
		}
		Scanner sc = new Scanner(System.in);
		crimeCase cc = null;
		crimeCase a[] = new crimeCase[2];
		for(int i=0;i<a.length;i++) {
			cc = new crimeCase();
			System.out.println("Enter the id of crime:");
			cc.caseId=sc.nextInt();
			System.out.println("Enter the name of crime:");
			cc.criminalName=sc.next();
			System.out.println("Enter the crime type:");
			cc.crimeType=sc.next();
			System.out.println("Enter the year of punishment:");
			cc.yearsPunishment=sc.nextInt();
			a[i]=cc;
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].caseId+" "+a[i].criminalName+" "+a[i].crimeType+" "+a[i].yearsPunishment);
		}
	}

}
