import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class main{
	static void printWelcomeMessage() {
		System.out.println("Hello from a Java function!");
	}

	public static void main(String[] args) {
		CyclicBarrier readyCountDownLatch = new CyclicBarrier(4);

		Thread taskThread = new Thread(new Task(readyCountDownLatch,1));
		Thread taskThread2 = new Thread(new Task(readyCountDownLatch,2 ));
		Thread taskThread3 = new Thread(new Task(readyCountDownLatch,3 ));
		Thread taskThread4 = new Thread(new Task(readyCountDownLatch,4));

		taskThread.start();
		taskThread2.start();
		taskThread3.start();
		taskThread4.start();
		System.out.println("All tasks are ready. Unblocking them now.");
	}
}