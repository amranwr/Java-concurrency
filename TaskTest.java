import java.util.concurrent.CyclicBarrier;

import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void cyclicBarrierTest_fourThreadsWaitsTillAllReady() {
		CyclicBarrier readyCountDownLatch = new CyclicBarrier(4);

		Thread taskThread = new Thread(new CyclicBarierExecutor(readyCountDownLatch,1));
		Thread taskThread2 = new Thread(new CyclicBarierExecutor(readyCountDownLatch,2 ));
		Thread taskThread3 = new Thread(new CyclicBarierExecutor(readyCountDownLatch,3 ));
		Thread taskThread4 = new Thread(new CyclicBarierExecutor(readyCountDownLatch,4));

		taskThread.start();
		taskThread2.start();
		taskThread3.start();
		taskThread4.start();
		System.out.println("All tasks are ready. Unblocking them now.");
    }

	@Test
	public void semaphoreMutexCounterTest() throws InterruptedException {
		SemaphoreMutexCounter counter = new SemaphoreMutexCounter();
		Thread thread1 = new Thread(() -> {
			try {
				counter.increment();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				counter.increment();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("Final count: " + counter.getCount());
	}
}