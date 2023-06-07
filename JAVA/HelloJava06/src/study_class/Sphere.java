package study_class;

public class Sphere extends Circle {
	protected String color;

	public double calcVolume() {
		double r = getR();
		double PI = getPI();
		return (4 / 3.0) * PI * r * r * r;
	}

	public void spin() {
		System.out.println(color + "���� ȸ���մϴ�.");
	}

	@Override
	public void dance() {
		// TODO Auto-generated method stub
		super.dance();
		System.out.println("3D ���� ȸ���Դϴ�.");
	}

	public void breakCircle() {
		System.out.println("���� :" + calcVolume());
		System.out.println("3D ���� �ҹ�� ��");
	}
}
