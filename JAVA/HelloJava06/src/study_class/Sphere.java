package study_class;

public class Sphere extends Circle {
	protected String color;

	public double calcVolume() {
		double r = getR();
		double PI = getPI();
		return (4 / 3.0) * PI * r * r * r;
	}

	public void spin() {
		System.out.println(color + "색이 회전합니다.");
	}

	@Override
	public void dance() {
		// TODO Auto-generated method stub
		super.dance();
		System.out.println("3D 구의 회전입니다.");
	}

	public void breakCircle() {
		System.out.println("부피 :" + calcVolume());
		System.out.println("3D 구의 뚝배기 깸");
	}
}
