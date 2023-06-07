package que01;

import java.util.Scanner;

public class asd {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		if (count < 1 || count > 1000) {
		    System.out.println("ERROR count");
		    scanner.close();
		    return;
		}
		int[] number = new int[count];
		for (int i = 0; i < count; i++) {
		    number[i] = scanner.nextInt();
		}
		scanner.close();

		for (int i = 0; i < count; i++) {
		    for (int j = i; j < count - 1; j++) {
			if (number[j] > number[j + 1]) {
			    int temp = number[j];
			    number[j] = number[j + 1];
			    number[j + 1] = temp;
			    j = i;
			}
			// System.out.println("for2 : " + j);
		    }
		    // System.out.println("for : " + i);
		}

		for (int i = 0; i < count; i++) {
		    System.out.println(number[i]);
		}
	}
}
