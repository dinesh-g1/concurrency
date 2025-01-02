package deadlivelock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLiveLockDriver {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        int waitTime1 = 1000;
        int waitTime2 = 1000;
        String[] names = new String[]{"Thread1", "Thread2"};
        Thread t1 = new Thread(new Worker(lock1, lock2, waitTime1, names[0]));
        Thread t2 = new Thread(new Worker(lock2, lock1, waitTime2, names[1]));
        t1.start();
        t2.start();
    }
}
