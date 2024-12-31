package specialseries;

public class Even implements Runnable{
    private final Object lock;

    public Even(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside even...");
            while (SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
                while (!(SpecialSeriesDriver.i > 0 && SpecialSeriesDriver.i % 2 == 0) && SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (SpecialSeriesDriver.reset > SpecialSeriesDriver.n) {
                    lock.notifyAll();
                    break;
                }
                System.out.println("Even: " + SpecialSeriesDriver.i);
                SpecialSeriesDriver.i = 0;
                SpecialSeriesDriver.reset++;
                lock.notifyAll();
            }
        }
    }
}
