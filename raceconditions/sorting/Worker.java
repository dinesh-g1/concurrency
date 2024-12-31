package sorting;

public class Worker implements Runnable{
    private final int val;
    private final Object lock;

    public Worker(int val, Object lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (val != SortedThreadsDriver.curr) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(val);
            SortedThreadsDriver.curr++;
            lock.notifyAll();
        }
    }
}
