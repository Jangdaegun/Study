package study_class;

public class Circle {
	private int r;
	private static double PI = 3.14;

	
	public Circle() {
		System.out.println("anything");
	}

	public Circle(int r) {
		this.r = r;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public static double getPI() {
		return PI;
	}

	public static void setPI(double pI) {
		PI = pI;
	}

	public double getArea() {
		return PI * r * r;
	}

	public double getround() {
		return 2 * r * PI;
	}

	
	public void dance() {
		System.out.println("반지름이" + getR() + "인 원의 춤");
	}

}
