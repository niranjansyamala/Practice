package com.practice.test.inher;

import java.util.concurrent.*;

public class ProducerConsumer {

	static BlockingQueue<Integer> sharedObject = new ArrayBlockingQueue<Integer>(10);

	static int i = 0;

	public static class Consumer implements Runnable {
		BlockingQueue<Integer> sharedObject = null;

		public Consumer(BlockingQueue<Integer> sharedObject) {
			this.sharedObject = sharedObject;
		}

		public void run() {
			try {
				while (i > 0)
					System.out.println("Consumed:" + sharedObject.take());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Producer implements Runnable {
		BlockingQueue<Integer> sharedObject = null;

		public Producer(BlockingQueue<Integer> sharedObject) throws InterruptedException {
			this.sharedObject = sharedObject;
		}

		public void run() {
			while (i < 10)
				System.out.println("Produced " + sharedObject.add(i++));
		}

	}

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(new Producer(sharedObject));
		executor.submit(new Consumer(sharedObject));

	}
}
