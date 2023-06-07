package trycatch;

public class ThrowError {

	public static int power(int n) throws Exception {
		if (n <= 0)
			throw new Exception("¾ç¼ö¸¸ µÊ!");
		return n * n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = power(10);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int b = power(-10);
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
