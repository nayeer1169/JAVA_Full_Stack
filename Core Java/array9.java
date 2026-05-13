//object in array - space mission records

import java.util.Scanner;

public class array9 {

	public static void main(String[] args) {
		class spaceMission{
			String missionName;
			int launchYear;
			String planetTarget;
			boolean successStatus;
		}
		Scanner sc = new Scanner(System.in);
		
		spaceMission a[] = new spaceMission[2];
		spaceMission sm = null;
		for(int i=0;i<a.length;i++) {
			sm = new spaceMission();
			System.out.println("Enter the name of mission: ");
			sm.missionName=sc.next();
			System.out.println("Enter the year for the mission: ");
			sm.launchYear = sc.nextInt();
			System.out.println("Enter the planet target of  mission: ");
			sm.planetTarget = sc.next();
			System.out.println("Enter the succes/failure of mission: ");
			sm.successStatus = sc.nextBoolean();
			a[i]=sm;
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i].missionName+" "+a[i].launchYear+" "+a[i].planetTarget+" "+a[i].successStatus);
		}
	}

}
