import java.util.TreeSet;


class Student122 implements Comparable<Student122>{
	private int rollno;
	private String name;
	private String branch;
	private float cgpa;
	private int age;
	

	

	public Student122(int rollno, String name, String branch, float cgpa, int age) {
		this.rollno = rollno;
		this.name = name;
		this.branch = branch;
		this.cgpa = cgpa;
		this.age = age;
	}




	@Override
	public int compareTo(Student122 s2) {
		Student122 s1 = this;
		
		String branch1 = s1.branch;
		String branch2 = s2.branch;
		
		if(branch1.equals(branch2)) {
			Float cgpa1 = s1.cgpa;
			Float cgpa2 = s2.cgpa;
			
			if(cgpa1.equals(cgpa2)) {
				String name1 = s1.name;
				String name2 = s2.name;
				
				if(name1.equals(name2)) {
					Integer roll1 = s1.rollno;
					Integer roll2 = s2.rollno;
					
					return roll1.compareTo(roll2);
				}
				
				return name1.compareTo(name2);
			}
			return cgpa2.compareTo(cgpa1);   //descending order
		}
		return branch1.compareTo(branch2);
	}
	@Override
	public String toString() {
		return "Roll no : "+rollno+
				" | Name : "+name+
				" | Branch : "+branch+
				" | CGPA : "+cgpa+
				" | Age : "+age;
	}
	
	
}

public class comparable {

	public static void main(String[] args) {
		TreeSet<Student122> students = new TreeSet<Student122>();
		
		Student122 s1 = new Student122(1, "Nayeer" , "CSE", 7.99f , 23);
		Student122 s2 = new Student122(2, "Deepak" , "CSE", 8.99f , 22);
		Student122 s3 = new Student122(3, "Sankalp" , "CSE", 8.55f , 23);
		Student122 s4 = new Student122(4, "Adarsh" , "CSE", 9.09f , 22);
		Student122 s5 = new Student122(5, "Ashish" , "CSE", 8.56f , 24);
		
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s2);
		students.add(s1);
		
		System.out.println("Student Details After Sorting\n");
		System.out.println(students);
		

	}

}
