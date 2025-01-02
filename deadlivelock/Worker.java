package deadlivelock;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{
    private final ReentrantLock lock1, lock2;
    private final int waitTime;
    private final String name;

    public Worker(ReentrantLock lock1, ReentrantLock lock2, int waitTime, String name) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.waitTime = waitTime;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (lock1.tryLock()) {
                try {
                    Thread.sleep(waitTime);
                    if (lock2.tryLock()) {
                        try {
                            System.out.println(name + " acquired both locks.");
                            return;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println("Gotten into dead lock.");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock1.unlock();
                }
            }
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
