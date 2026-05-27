//Crime case database
import java.util.Scanner;

class CrimeCase {

	private int caseId;
	private String criminalName;
	private String crimeType;

	//default constructor
	public CrimeCase() {

	}

	//Parameterized constructor
	public CrimeCase(int caseId, String criminalName, String crimeType) {
		this.caseId = caseId;
		this.criminalName = criminalName;
		this.crimeType = crimeType;
	}

	//we have already have setter (constructor )
	//but then also we are making just in case if we want to change value manually

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	//now method for the getters.

	public int getCaseId() {
		return caseId;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public String getCrimeType() {
		return crimeType;
	}

}

public class Encapsulation_Constructor6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no of crime cases:");
		int n = sc.nextInt();
		sc.nextLine();

		CrimeCase c = null;

		CrimeCase[] ar = new CrimeCase[n];

		for (int i = 0; i < ar.length; i++) {

			System.out.println("Enter the crime case details:");
			String crimeDetails = sc.nextLine();

			String[] ar2 = crimeDetails.split(",");

			c = new CrimeCase(Integer.parseInt(ar2[0]), ar2[1], ar2[2]);

			ar[i] = c;
		}

		for (int i = 0; i < ar.length; i++) {

			System.out.println(ar[i].getCaseId());
			System.out.println(ar[i].getCriminalName());
			System.out.println(ar[i].getCrimeType());
		}

	
	}

}