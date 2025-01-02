package customlock;

public class DirtyWorker implements Runnable{
    private final CustomLock lock;

    public DirtyWorker(CustomLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.unlock();
    }
}
