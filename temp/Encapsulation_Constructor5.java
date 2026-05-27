//Space mission details
import java.util.Scanner;

class SpaceMission {

	private String missionName;
	private String country;
	private int budget;

	//default constructor
	public SpaceMission() {

	}

	//Parameterized constructor
	public SpaceMission(String missionName, String country, int budget) {
		this.missionName = missionName;
		this.country = country;
		this.budget = budget;
	}

	//we have already have setter (constructor )
	//but then also we are making just in case if we want to change value manually

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	//now method for the getters.

	public String getMissionName() {
		return missionName;
	}

	public String getCountry() {
		return country;
	}

	public int getBudget() {
		return budget;
	}

}

public class Encapsulation_Constructor5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no of space missions:");
		int n = sc.nextInt();
		sc.nextLine();

		SpaceMission sm = null;

		SpaceMission[] ar = new SpaceMission[n];

		for (int i = 0; i < ar.length; i++) {

			System.out.println("Enter the mission details:");
			String missionDetails = sc.nextLine();

			String[] ar2 = missionDetails.split(",");

			sm = new SpaceMission(ar2[0], ar2[1], Integer.parseInt(ar2[2]));

			ar[i] = sm;
		}

		for (int i = 0; i < ar.length; i++) {

			System.out.println(ar[i].getMissionName());
			System.out.println(ar[i].getCountry());
			System.out.println(ar[i].getBudget());
		}

		
	}

}