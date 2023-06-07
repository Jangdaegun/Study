package inheritance;

public class UnivStudent extends Student {

	public UnivStudent(String name, int age) {
		super(name, age);
	}

	private String hakbeon;

	public String getHakbeon() {
		return hakbeon;
	}

	public void setHakbeon(String hakbeon) {
		this.hakbeon = hakbeon;
	}

	public UnivStudent(String name, int age, String hakbeon) {
		super(name, age);
		this.hakbeon = hakbeon;
	}
	
	@Override
	public void study() {
		// TODO Auto-generated method stub
		super.study();
		System.out.println(getHakbeon() + "�й��� ������");
		System.out.println("���л�ó�� �����ϽŴ�");
	}

}
