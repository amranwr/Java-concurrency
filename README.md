# java concurrency
- CountDownLatch: countDownLatch (introduced in JDK 5) is a utility class which blocks a set of threads until some operation completes.A CountDownLatch is initialized with a counter(Integer type); this counter decrements as the dependent threads complete execution. But once the counter reaches zero, other threads get released.
- cyclic barier.
- semaphore.
- blockingQueue: in asynchronous programming, one of the most common integration patterns is the producer-consumer pattern. The java.util.concurrent package comes with a data-structure know as BlockingQueue – which can be very useful in these async scenarios.
- DelayQueue: same as blocking queues but wait for a specific amount of time before you can poll the element from the queue.
- Phaser: phaser is a more flexible solution than CyclicBarrier and CountDownLatch – used to act as a reusable barrier on which the dynamic number of threads need to wait before continuing execution. We can coordinate multiple phases of execution, reusing a Phaser instance for each program phase.
