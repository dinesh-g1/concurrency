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
        while (compare()) {}
        System.out.print(val + " ");
        synchronized (lock) {
            SortedThreadsDriver.curr++;
        }
    }
    public boolean compare() {
        boolean result = false;
        synchronized (lock) {
            result = val > SortedThreadsDriver.curr;
        }
        return result;
    }
}
