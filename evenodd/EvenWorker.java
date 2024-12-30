package evenodd;

public class EvenWorker implements Runnable {
    private final String name;
    private final Object lock;

    public EvenWorker(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (EvenOddDriver.curr > EvenOddDriver.limit)
                    break;
                if (EvenOddDriver.curr % 2 == 0) {
                    System.out.println(name + " : " + EvenOddDriver.curr);
                    EvenOddDriver.curr++;
                }
            }
        }

    }
}