package object_class;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student(10,"�̵���");
		Student s2 = new Student(10,"������");
		Student s3 = new Student(30,"�̵���");
		Student s4 = new Student(10,"������");
		
		Person p1 = new Person(40,"����ȣ");
		Person p2 = new Person(40,"����ȣ");
		
		String ss1 = "�Һ���";
		String ss2 = "�Һ���";
		String ss3 = new String("�Һ���");
		
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
