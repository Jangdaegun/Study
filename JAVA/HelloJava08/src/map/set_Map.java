package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class set_Map {

	public static void main(String[] args) {
		// Set : �ߺ��� ��� X , ������ ���� ����Ʈ
		// Map : key-value , Ű�� �ߺ��Ǹ� ���� �� ����

		Set<Integer> numbers = new HashSet<Integer>();
		HashSet<Integer> numbers2 = new HashSet<Integer>();

		numbers.add(1);
		numbers.add(56);
		numbers.add(3);
		numbers.add(1);

		for (int items : numbers) {
			System.out.println(items);
		}

		Map<Integer, String> students = new HashMap<Integer, String>();
		students.put(1, "�̵���");
		students.put(2, "�̼���");
		students.put(1, "��ȫ��");

		for (int key : students.keySet()) {
			System.out.println(key + " " + students.get(key));
		}

		HashSet<Employee> company = new HashSet<Employee>();
		company.add(new Employee("��ȫ��", "001", 44));
		company.add(new Employee("�ڼ���", "002", 45));
		company.add(new Employee("�̵���", "003", 46));
		company.add(new Employee("�Һ���", "003", 26));

		for (Employee item : company) {
			System.out.println(item.getSabeon() + "," + item.getName() + "," + item.getAge());
		}
		
		
		
	}

}















