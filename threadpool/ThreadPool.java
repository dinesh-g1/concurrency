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
    private boolean hasShutDown;

    public ThreadPool(int maxThreads) {
        workers = new ArrayList<>();
        this.maxThreads = maxThreads;
        hasShutDown = false;
        queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < maxThreads; i++) {
            Thread t = new Thread(new Worker(queue, i));
            workers.add(t);
        }
        for (Thread t : workers) {
            t.start();
        }
    }

    public synchronized FutureTask<Integer> submit(Callable<Integer> task) throws InterruptedException {
        if (hasShutDown)
            throw new RuntimeException("No new requests will be entertained...");
        FutureTask<Integer> fTask = new FutureTask<>(task);
        queue.put(fTask);
        return fTask;
    }

    public synchronized void shutdown() throws InterruptedException {
        hasShutDown = true;
        for (int q = 0; q < workers.size(); q++) {
           queue.put(new Shutter());
        }
    }
}
