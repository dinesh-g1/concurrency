package fizzbuzz;

public class Buzz implements Runnable {
    private final Object lock;

    public Buzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside Buzz...");
            while (FizzBuzzDriver.i <= FizzBuzzDriver.end) {
                boolean isBuzz = (FizzBuzzDriver.i % 5 == 0 && FizzBuzzDriver.i % 3 != 0);
                if (!isBuzz) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Buzz - " + FizzBuzzDriver.i);
                    FizzBuzzDriver.i++;
                    lock.notifyAll();
                }
            }
        }
    }
}
