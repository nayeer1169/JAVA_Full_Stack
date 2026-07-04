import java.util.TreeSet;

class Patient111 implements Comparable<Patient111>{
	private int patientId;
	private String patientName;
	private String disease;
	private String doctorName;
	private float billAmount;;
	private int age;
	
	public Patient111(int patientId, String patientName, String disease, String doctorName, float billAmount, int age) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.disease = disease;
		this.doctorName = doctorName;
		this.billAmount = billAmount;
		this.age = age;
	}
	@Override
	public int compareTo(Patient111 p2) {
		Patient111 p1= this;
		
		String disease1 = p1.disease;
		String disease2 = p2.disease;
		
		if(disease1.equals(disease2)) {
			String doctorName1 = p1.doctorName;
			String doctorName2 = p2.doctorName;
			
			if(doctorName.equals(doctorName2)) {
				Float billAmount1 = p1.billAmount;
				Float billAmount2 = p2.billAmount;
				
				if(billAmount1.equals(billAmount2)) {
					String patientName1 = p1.patientName;
					String patientName2 = p2.patientName;
					
					if(patientName.equals(patientName2)) {
						Integer patientId1 = p1.patientId;
						Integer patientId2 = p2.patientId;
						
						return patientId1.compareTo(patientId2);
					}
					return patientName1.compareTo(patientName2);
				}
				return billAmount1.compareTo(billAmount2);
			}
			return doctorName1.compareTo(doctorName2);
		}
		return disease1.compareTo(disease2);
	}

	@Override
	public String toString() {
		return "PatientID : "+patientId+
			   "| Patient Name : "+patientName+
			   "| Disease : "+disease+
			   "| Doctor Name : "+doctorName+
			   "| Bill Amount : "+billAmount+
			   "| Age : "+age;
	}
	
	
}
public class comparable2 {

	public static void main(String[] args) {
		TreeSet<Patient111> patients = new TreeSet<Patient111>();
		
		Patient111 p1 = new Patient111(1, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p2 = new Patient111(2, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p3 = new Patient111(3, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p4 = new Patient111(4, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p5 = new Patient111(5, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p6 = new Patient111(6, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		Patient111 p7 = new Patient111(7, "Darubaz", "Yo" , "SRK", 45000.0f, 67);
		
	    patients.add(p7);
	    patients.add(p6);
	    patients.add(p5);
	    patients.add(p4);
	    patients.add(p3);
	    patients.add(p2);
	    patients.add(p1);
		
		System.out.println("Patient Details after sorting\n");
		
		for (Patient111 patient : patients) {
			System.out.println(patient);			
		}

		

	}

}
