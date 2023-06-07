package study_class;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Sol {

	static void register() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();

		s1.name = sc.nextLine();
		s1.beonho = sc.nextInt();
		sc.nextLine();
		s1.gender = sc.nextLine();

		s2.name = sc.nextLine();
		s2.beonho = sc.nextInt();
		sc.nextLine();
		s2.gender = sc.nextLine();

		s3.name = sc.nextLine();
		s3.beonho = sc.nextInt();
		sc.nextLine();
		s3.gender = sc.nextLine();

		Student s4[] = new Student[5];
		s4[0] = s1;
		s4[1] = s2;
		s4[2] = s3;
		s4[3] = new Student();
		s4[4] = new Student();
		s4[3].name = "사람4";
		s4[3].beonho = 4;
		s4[3].gender = "여성";
		s4[4].name = "사람5";
		s4[4].beonho = 5;
		s4[4].gender = "여성";

		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student());
		students.get(0).name = "사람10";
		students.get(0).beonho = 10;
		students.get(0).gender = "남성";
		students.add(new Student());
		students.get(1).name = "사람9";
		students.get(1).beonho = 9;
		students.get(1).gender = "남성";
		students.add(new Student());
		students.get(2).name = "사람8";
		students.get(2).beonho = 8;
		students.get(2).gender = "남성";
		for (int i = 0; i < s4.length; i++)
			System.out.println(s4[i].name + " " + s4[i].beonho + " " + s4[i].gender);
		
//		for (int i = 0; i < s4.length; i++)
//			System.out.printf("%s %d %s", s4[i].name, s4[i].beonho, s4[i].gender);
		
//		for (int i = 0; i < s4.length; i++)
//			System.out.println(String.format("%s %s %d", s4[i].name, s4[i].gender, s4[i].beonho));
		
		for (Student item : students)
			System.out.println(item.beonho);
	}

}
