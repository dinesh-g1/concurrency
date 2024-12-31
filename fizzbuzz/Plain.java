package fizzbuzz;

public class Plain implements Runnable{
    private final Object lock;

    public Plain(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            //System.out.println("Inside Plain...");
            while (FizzBuzzDriver.i <= FizzBuzzDriver.end) {
                boolean isPlain = (FizzBuzzDriver.i % 3 != 0 && FizzBuzzDriver.i % 5 != 0);
                if (!isPlain) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Plain - " + FizzBuzzDriver.i);
                    FizzBuzzDriver.i++;
                    lock.notifyAll();
                }
            }
        }
    }
}
