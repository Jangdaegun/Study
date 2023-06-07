package study01_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class list01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List numbers = new ArrayList<Integer>();
		ArrayList nums = new ArrayList<Integer>();

		List linkedlist = new LinkedList<Integer>();

		ArrayList<Integer> mynumbers = new ArrayList<Integer>();

		mynumbers.add(10);
		mynumbers.add(20);
		mynumbers.add(15);
		mynumbers.set(0, -10);
		for (int i = 0; i < mynumbers.size(); i++)
			System.out.println(mynumbers.get(i));

		mynumbers.remove(1);
		for (int i = 0; i < mynumbers.size(); i++)
			System.out.println(mynumbers.get(i));

		ArrayList<String> students = new ArrayList<String>();
		students.add("소병수");
		students.add("정홍근");
		students.add("박준호");
		students.add("정선호");

		for (String string : students) {
			System.out.println(string);
		}
	}

}
