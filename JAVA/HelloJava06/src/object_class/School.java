package object_class;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student(10,"이동준");
		Student s2 = new Student(10,"최은지");
		Student s3 = new Student(30,"이동준");
		Student s4 = new Student(10,"최은지");
		
		Person p1 = new Person(40,"박준호");
		Person p2 = new Person(40,"박준호");
		
		String ss1 = "소병수";
		String ss2 = "소병수";
		String ss3 = new String("소병수");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s4.toString());
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println(s2.equals(s4));
		System.out.println(p1.equals(p2));
		System.out.println(ss1==ss2);
		System.out.println(ss1==ss3);
		System.out.println(ss1.equals(ss3));
	}

}
