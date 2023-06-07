package sol;

public class Circle {
	private int r;
	private final double PI = 3.14;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		if (r <= 0) {
			System.out.println("Error!");
			this.r = 0;
			return;
		}
		this.r = r;
	}

	public Circle() {

	}

	public Circle(int r) {
		setR(r);
	}

	public double getPI() {
		return PI;
	}

	public double getRound() {
		return 2 * PI * r;
	}

	public double getArea() {
		return PI * r * r;
	}

}
