package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class set_Map {

	public static void main(String[] args) {
		// Set : 중복을 허용 X , 순서가 없는 리스트
		// Map : key-value , 키가 중복되면 기존 값 삭제

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
		students.put(1, "이동준");
		students.put(2, "이수성");
		students.put(1, "정홍근");

		for (int key : students.keySet()) {
			System.out.println(key + " " + students.get(key));
		}

		HashSet<Employee> company = new HashSet<Employee>();
		company.add(new Employee("정홍근", "001", 44));
		company.add(new Employee("박세진", "002", 45));
		company.add(new Employee("이동준", "003", 46));
		company.add(new Employee("소병수", "003", 26));

		for (Employee item : company) {
			System.out.println(item.getSabeon() + "," + item.getName() + "," + item.getAge());
		}
		
		
		
	}

}
















