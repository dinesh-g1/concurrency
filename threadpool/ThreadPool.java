package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadPool {
    private final int maxThreads;
    private final BlockingQueue<Runnable> queue;
    private final List<Thread> workers;

    public ThreadPool(int maxThreads) {
        workers = new ArrayList<>();
        this.maxThreads = maxThreads;
        queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < maxThreads; i++) {
            Thread t = new Thread(new Worker(queue, i));
            workers.add(t);
        }
        for (Thread t : workers) {
            t.start();
        }
    }

    public FutureTask<Integer> submit(Callable<Integer> task) throws InterruptedException {
        FutureTask<Integer> fTask = new FutureTask<>(task);
        queue.put(fTask);
        return fTask;
    }
}
