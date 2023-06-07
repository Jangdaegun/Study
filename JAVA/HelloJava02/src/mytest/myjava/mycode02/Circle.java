package mytest.myjava.mycode02;

import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("원의 반지름 : ");
		int N = sc.nextInt();
		
		double PI = 3.14;
		double area = PI * N * N;
		double round = PI * 2 * N;
		
		System.out.println("원의 넓이 : " + area);
		System.out.println("원의 둘레 : " + (float)round);
	}

}
