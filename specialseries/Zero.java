package specialseries;

public class Zero implements Runnable{
    private final Object lock;

    public Zero(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside zero...");
            while (SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
                while (SpecialSeriesDriver.i != 0 && SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
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
                    System.out.println("Zero: " + SpecialSeriesDriver.i);
                    SpecialSeriesDriver.i = SpecialSeriesDriver.reset;
                    lock.notifyAll();

            }
        }
    }
}
