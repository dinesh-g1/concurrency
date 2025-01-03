package semaphore;

public class Semaphore {
    private final int maxAllowable;
    private int currentPermits;

    public Semaphore(int maxAllowable) {
        if (maxAllowable < 0)
            throw new RuntimeException("Negative number of permissions not allowed");
        this.maxAllowable = maxAllowable;
    }

    public synchronized void acquire() throws InterruptedException {
        while (currentPermits == 0)
            wait();
        currentPermits--;
    }

    public synchronized void release() {
        if (currentPermits == maxAllowable) {
            throw new RuntimeException("Exceeded the number of permits");
        }
        currentPermits++;
        if (currentPermits == 1)
            notifyAll();
    }
}
