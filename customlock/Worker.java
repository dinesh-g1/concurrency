package customlock;

public class Worker implements Runnable{
    private final CustomLock lock;

    public Worker(CustomLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    }
}
