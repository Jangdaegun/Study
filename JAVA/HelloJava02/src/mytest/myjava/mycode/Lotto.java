package mytest.myjava.mycode;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bns = (int) (Math.random() * 45 + 1);
		int lotto[] = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			if (bns == lotto[i]) {
				bns = (int) (Math.random() * 45 + 1);
				i = -1;
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		System.out.println("보너스번호 : " + bns);
	}

}
