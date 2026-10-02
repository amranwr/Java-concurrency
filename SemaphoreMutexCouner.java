import java.util.concurrent.Semaphore;

class SemaphoreMutexCounter {
    private int count;
    private final Semaphore semaphore;

    public SemaphoreMutexCounter() {
        this.count = 0;
        this.semaphore = new Semaphore(1); // Binary semaphore for mutual exclusion
    }

    public void increment() throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getName() + " is trying to acquire the semaphore.");
        semaphore.acquire(); // Acquire the semaphore before entering critical section
        System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the semaphore.");
        try {
            count++;
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the semaphore.");
            semaphore.release(); // Release the semaphore after leaving critical section
        }
    }

    public int getCount() {
        return count;
    }
}