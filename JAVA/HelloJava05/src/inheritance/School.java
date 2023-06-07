package inheritance;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("¿Ãµø¡ÿ",35);
		UnivStudent u1 = new UnivStudent(s1.getName(),s1.getAge(), "2009038033");
		s1.sleep();
		System.out.println();
		u1.sleep();
		System.out.println();
		s1.study();
		System.out.println();
		u1.study();
	}

}
