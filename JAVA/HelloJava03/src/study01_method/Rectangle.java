package study01_method;

public class Rectangle {

	static int rectangle(int a, int b) {
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		return a * b;
	}

	static int square(int a) {
		if (a < 0) {
			System.out.println("¿À·ù");
			return 0;
		}
		return a * a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rectangle(3, 4));
		System.out.println(rectangle(-5, 4));
		System.out.println(square(3));
		System.out.println(square(-5));
	}

}
