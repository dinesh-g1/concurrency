package specialseries;

public class Odd implements Runnable{
    private final Object lock;

    public Odd(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
                while (!(SpecialSeriesDriver.i > 0 && SpecialSeriesDriver.i % 2 != 0) && SpecialSeriesDriver.reset <= SpecialSeriesDriver.n) {
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
                System.out.println("Odd: " + SpecialSeriesDriver.i);
                SpecialSeriesDriver.i = 0;
                SpecialSeriesDriver.reset++;
                lock.notifyAll();
            }
        }
    }
}
