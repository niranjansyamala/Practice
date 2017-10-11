package com.practice.test;

import java.util.HashSet;
import java.util.Set;

public class LCS {

	public static void main(String[] args) throws InterruptedException {
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread());

		System.out.println("Now main sleeping... press ctrl+c to exit");
		try {
			main(args);
		}
		catch (Exception e) {
		}
	}

}

class MyThread extends Thread {

	@Override public void run() {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}

	public static void lcs(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		int max = 0;
		int lcs[][] = new int[m][n];

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {

				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == 0 || j == 0) {
						lcs[i][j] = 1;
					}
					else {
						lcs[i][j] = lcs[i - 1][j - 1] + 1;
					}
					if (max < lcs[i][j]) {
						max = lcs[i][j];
					}
				}

			}
		}

		System.out.println(max);

	}

}
