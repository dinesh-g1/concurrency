package concurrentsum;

public class PluckAndAddWorker implements Runnable {
    private final Container container;
    private final Object lock;

    public PluckAndAddWorker(Container container, Object lock) {
        this.container = container;
        this.lock = lock;
    }
    @Override
    public void run() {
        int val = 0;
        while (true) {
            val = container.pluck();
            if (val == -1)
                break;

            synchronized (lock) {
                ConcurrentSumDriver.sum += val;
            }
        }
    }
}
