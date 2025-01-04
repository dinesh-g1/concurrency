package executorservice;

public class Worker implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getThreadGroup().getName() + " | " + Thread.currentThread().getName());
    }
}
