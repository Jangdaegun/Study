package study01_method;

public class OverLoading {

	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	}

	static int add(char a, char b) {
		return a + b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((add(1, 2)));
		System.out.println((add(3.14, 3.86)));
		System.out.println((add('A', 'a')));
	}

}
