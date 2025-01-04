package threadpool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadPool {
    private final BlockingQueue<Runnable> queue;
    private final List<Thread> workers;
    private boolean hasShutDown;
    private final Set<Integer> deadThreadIds;

    public ThreadPool(int maxThreads) {
        this.deadThreadIds = new HashSet<>();
        workers = new ArrayList<>();
        hasShutDown = false;
        queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < maxThreads; i++) {
            Thread t = new Thread(new Worker(queue, i, deadThreadIds));
            workers.add(t);
        }
        for (Thread t : workers) {
            t.start();
        }
        Thread bookKeeper = new Thread(new BookKeeper(deadThreadIds, workers, queue));
        bookKeeper.start();
    }

    public synchronized FutureTask<Integer> submit(Callable<Integer> task) throws InterruptedException {
        if (hasShutDown)
            throw new RuntimeException("No new requests will be entertained...");
        FutureTask<Integer> fTask = new FutureTask<>(task);
        queue.put(fTask);
        return fTask;
    }

    public synchronized void submit(Runnable runnable) throws InterruptedException {
        if (hasShutDown)
            throw new RuntimeException("No new requests will be entertained...");
        queue.put(runnable);
    }

    public synchronized void shutdown() throws InterruptedException {
        hasShutDown = true;
        for (int q = 0; q < workers.size(); q++) {
           queue.put(new Shutter());
        }
        this.deadThreadIds.add(-1);
    }
}
