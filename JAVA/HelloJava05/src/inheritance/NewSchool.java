package inheritance;

public class NewSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("이수성", 26);
		UnivStudent u1 = new UnivStudent("소병수", 30, "100");
		Kindergarten k1 = new Kindergarten("최은지", 3, 170.1, 30.6);
		MasterStudent m1 = new MasterStudent("이동준", 45, "20090303", "황우석");

		System.out.println("Student");
		s1.study();
		s1.sleep();
		System.out.println("UnivStudent");
		u1.study();
		u1.sleep();
		System.out.println("Kindergarten");
		k1.study();
		k1.sleep();
		System.out.println("MasterStudent");
		m1.study();
		m1.sleep();
		m1.cleanRoom();
		m1.cleanRoon("화장실");
	}

}
