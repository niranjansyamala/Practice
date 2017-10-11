package com.practice.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Practice implements Runnable {

	public void mOne() {
		Lock lock = new ReentrantLock();
		lock.lock();
		System.out.println("Locked");
	}

	public void mTwo(Lock lock) {
		lock.unlock();
	}

	public void run() {
		System.out.println("In runt");
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 5,9,8,9 };

		//reverseArray(a, 0, a.length - 1);
		//printArray(a);


		System.out.println();

	}

	public static void reverseArray(int a[], int start, int end) {
		if (start >= end) {
			return;
		}
		a[start] = a[start] ^ a[end];
		a[end] = a[start] ^ a[end];
		a[start] = a[start] ^ a[end];
		reverseArray(a, start + 1, end - 1);
	}

	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}

	public int getOddOccurrence(int arr[]) {
		int len = arr.length;
		int res = 0;
		for (int j = 0; j < len - 1; j++) {
			res = res ^ arr[j];
		}
		return res;
	}

	public boolean arraySum(int a[], int sum) {
		int n = a.length;
		int currentSum = a[0];
		int start = 0;

		for (int i = 1; i < n; i++) {
			while (currentSum > sum && start < i - 1) {
				currentSum = currentSum - a[start];
				start++;
			}
			if (currentSum == sum) {
				int p = i - 1;
				return true;
			}

			if (i < n) {
				currentSum = currentSum + a[i];
			}

		}

		return false;
	}

	static int findOddman(int[] a) {
		int oddMan = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			oddMan = oddMan ^ a[i + 1];
		}
		return oddMan;
	}

	static int mPowN(int m, int n) {
		int sum = m;
		while (n > 1) {
			if (n % 2 == 0) {
				sum = sum * sum;
				n = n / 2;
			}
			else {
				sum = m * sum;
				n = n - 1;
			}

		}
		return sum;
	}



	static int findMax(int[] a){
		int max = a[0];
		for (int i: a){
			if(i>max){
				max = max ^ i;
				i = max ^ i;
				max = max ^ i;
			}

		}
		return max;
	}


	static int findSecondMax (int[] a, int max){
		int secondMax = -1*max;
		for (int i =0;i<a.length;i++){
			a[i] = a[i]-max;
		}


		for(int j=0;j<a.length;j++){
			if(a[j]!=0){
				if (a[j] > secondMax){
					secondMax = secondMax ^ a[j];
					a[j] = secondMax ^ a[j];
					secondMax = secondMax ^ a[j];
				}
			}
		}
		return secondMax + max;
	}

}
