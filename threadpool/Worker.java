package threadpool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private final BlockingQueue<Runnable> queue;
    private final int id;
    private final Set<Integer> deadThreadIds;

    public Worker(BlockingQueue<Runnable> queue, int id, Set<Integer> deadThreadIds) {
        this.queue = queue;
        this.id = id;
        this.deadThreadIds = deadThreadIds;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("thread " + id + " is working.");
            try {
                Runnable task = queue.take();
                task.run();
            } catch (Exception e) {
                if (e.getMessage().equals("Exit the thread pool")) {
                    synchronized (deadThreadIds) {
                        deadThreadIds.notifyAll();
                    }
                    break;
                }
                synchronized (deadThreadIds) {
                    deadThreadIds.add(id);
                    deadThreadIds.notifyAll();
                    System.out.println("Thread with id " + id + " died due to exception");
                }
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + id + " exited");
    }
}
