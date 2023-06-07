package mytest.myjava.mycode02;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 받을 정수의 개수는?");
		int N = sc.nextInt();
		int arr[] = new int[N];

		System.out.println(N+"개 정수 입력");
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int max_index = 0;
		int min_index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
			{
				max = arr[i];
				max_index = i;				
			}
			if (arr[i] < min) {
				min = arr[i];
				min_index = i;
			}
		}
		System.out.println("입력받은 정수 배열 : " + Arrays.toString(arr));
		System.out.println("최소값 index : " + min_index);
		System.out.println("최소값 : " + min);
		System.out.println("최대값 index : " + max_index);
		System.out.println("최대값 : " + max);
	}

}
