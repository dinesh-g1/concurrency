package latch;

public class CountDownLatch {
    private int count;

    public CountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + " is waiting on the latch.");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " is exited on the latch.");
    }

    public synchronized void countDown() {
        count--;
        if (count == 0)
            notifyAll();
        System.out.println(Thread.currentThread().getName() + " is decreased the count.");
    }
}
