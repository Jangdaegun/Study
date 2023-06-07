package trycatch;

import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램 시작");
		try {
			int a = 10;
			int b = 0;
			int c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("return!");
			e.printStackTrace();
			return;
		}finally {
			System.out.println("무조건 실행");
		}
		System.out.println("프로그램 종료");
		
		
		
		
	}

}
