package com.practice.test;

public class Towers {

	static void solve(int n, String start, String auxilary, String end) {
		if (n == 1) {
			System.out.println(start + "-->" + end);
		}
		else {
			solve(n - 1, start, end, auxilary);
			System.out.println(start + "-->" + end);
			solve(n - 1, auxilary, start, end);
		}
	}

	public static void main(String[] args) {

		solve(4, "A", "B", "C");

	}

}
