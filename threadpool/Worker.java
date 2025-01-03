package threadpool;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private final BlockingQueue<Runnable> queue;
    private final int id;

    public Worker(BlockingQueue<Runnable> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("thread " + id + " is working.");
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
