package customlock;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CustomLock lock = new CustomLock();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Worker(lock));
            Thread dw = new Thread(new DirtyWorker(lock));
            t.start();
            dw.start();
        }
    }
}
