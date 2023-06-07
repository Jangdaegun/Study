package abstract_study;

public class practice_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t1 = new MathTeacher();
		Teacher t2 = new ProgrammingTeacher();
		ProgrammingTeacher p1 = new JavaTeacher();
		
		t1.Teach();
		t2.Teach();
		p1.Teach();
	}

}
