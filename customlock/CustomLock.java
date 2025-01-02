package customlock;

public class CustomLock {
    private boolean isLocked;

    public CustomLock() {
        isLocked = false;
    }

    public synchronized void lock() {
        while (isLocked) {
            System.out.println(Thread.currentThread().getName() + " is waiting to get lock.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
        System.out.println(Thread.currentThread().getName() + " got the lock.");
    }
    public synchronized void unlock() {
        isLocked = false;
        System.out.println(Thread.currentThread().getName() + " released the lock.");
        notifyAll();
    }
}
