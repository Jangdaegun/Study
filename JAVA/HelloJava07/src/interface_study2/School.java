package interface_study2;

public class School {

	public static void main(String[] args) {
		Studiable[] students = new Studiable[5];
		students[0] = new ITStudent();
		students[1] = new ElecStudent();
		students[2] = new ArtStudent();
		students[3] = new Studiable() {
			
			@Override
			public void study() {
				System.out.println("������ �ʱ��ϸ� ����");
			}
		};
		for(Studiable studiable : students) {
			studiable.study();
			studiable.rest();
			System.out.println("-----");
		}
	}

}