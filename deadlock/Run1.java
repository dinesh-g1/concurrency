package deadlock;

public class Run1 implements Runnable{
    private final Object lock1;
    private final Object lock2;

    public Run1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            for (int i = 0; i < 10000000; i++) {}
            synchronized (lock2) {
                System.out.println("Running 1");
            }
        }
    }
}
