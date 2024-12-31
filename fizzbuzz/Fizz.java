package fizzbuzz;

public class Fizz implements Runnable {
    private final Object lock;

    public Fizz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside Fizz...");
            while (FizzBuzzDriver.i <= FizzBuzzDriver.end) {
                boolean isFizz = ((FizzBuzzDriver.i % 3) == 0 && (FizzBuzzDriver.i % 5 != 0));
                if (!isFizz) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Fizz - " + FizzBuzzDriver.i);
                    FizzBuzzDriver.i++;
                    lock.notifyAll();
                }
            }
        }
    }
}
