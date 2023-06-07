package mytest.myjava.mycode02;

import java.util.Arrays;
import java.util.Scanner;

public class StringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1번쨰 문자열");
		String s1 = sc.nextLine();
		System.out.println("2번쨰 문자열");
		String s2 = sc.nextLine();
		
		//System.out.println(s1.equals(s2));
		if(s1.length() != s2.length()) {
			System.out.println("다름");
			return;
		}
		
		boolean isSame = true;
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i = 0; i<c1.length; i++)
		{
			if(c1[i]!=c2[i])
			{
				isSame = false;
				break;
			}
		}
		if(isSame)
			System.out.println("똑같은 문자열임");
		else
			System.out.println("다른 문자열임");
	}

}
