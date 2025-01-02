package customlock;

public class CustomLock {
    private boolean isLocked;
    private Thread lockedBy;
    private int reentrants;

    public CustomLock() {
        isLocked = false;
        lockedBy = null;
        reentrants = 0;
    }

    public synchronized void lock() {
        while (isLocked && !Thread.currentThread().equals(lockedBy)) {
            System.out.println(Thread.currentThread().getName() + " is waiting to get lock.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isLocked = true;
        reentrants++;
        lockedBy = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " got the lock.");
    }
    public synchronized void unlock() {
        if (!isLocked)
            throw new RuntimeException("There is nothing to unlock");
        if (!Thread.currentThread().equals(lockedBy))
            throw new RuntimeException("Can't unlock which you don't own");
        reentrants--;
        if (reentrants == 0) {
            isLocked = false;
            lockedBy = null;
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            notifyAll();
        }
    }
}
