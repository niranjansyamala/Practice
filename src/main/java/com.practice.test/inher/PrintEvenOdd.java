package com.practice.test.inher;

public class PrintEvenOdd {

	public static void main(String[] args) {
		final Counter counter = new Counter(20);
		final int limit = 20;
		Runnable evenPrinter = new Runnable() {
			public void run() {
				int num = 0;
				while (true){
					if(num<=limit)
						num = counter.printEven();
				}

			}
		};

		Runnable oddPrinter = new Runnable() {
			public void run() {
				int num = 0;
				while (true) {
					if (num <= limit)
						num = counter.printOdd();
				}
			}
		};

		new Thread(oddPrinter).start();
		new Thread(evenPrinter).start();
	}

	static class Counter {
		int count = 0;
		boolean isOdd = true;
		int upperLimit;

		Counter(int upperLimit) {
			this.upperLimit = upperLimit;
		}

		public synchronized int printOdd() {
			if (!isOdd) {
				try {
					wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			System.out.println("Odd" + count);
			isOdd = false;
			notifyAll();
			return count;

		}

		public synchronized int printEven() {
			if (isOdd) {
				try {
					wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			isOdd = true;
			System.out.println("Even" + count);
			notifyAll();
			return count;

		}

	}

}
