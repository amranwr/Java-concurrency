import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int id;

    public Task(CyclicBarrier cyclicBarrier, int id) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " is ready.");
        
        try {
            cyclicBarrier.await();
            System.out.println("Task " + id + " has been unblocked and is proceeding.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (java.util.concurrent.BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    
}
