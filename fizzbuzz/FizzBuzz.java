package fizzbuzz;

public class FizzBuzz implements Runnable{
    private final Object lock;

    public FizzBuzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside FizzBuzz...");
            while (FizzBuzzDriver.i <= FizzBuzzDriver.end) {
                boolean isFizzBuzz = (FizzBuzzDriver.i % 3 == 0 && FizzBuzzDriver.i % 5 == 0);
                if (!isFizzBuzz) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("FizzBuzz - " + FizzBuzzDriver.i);
                    FizzBuzzDriver.i++;
                    lock.notifyAll();
                }
            }
        }
    }
}
