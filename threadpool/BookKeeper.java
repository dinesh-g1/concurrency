package threadpool;

import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class BookKeeper implements Runnable {
    private final Set<Integer> deadThreadIds;
    private final List<Thread> workers;
    private final BlockingQueue<Runnable> queue;

    public BookKeeper(Set<Integer> deadThreadIds, List<Thread> workers, BlockingQueue<Runnable> queue) {
        this.deadThreadIds = deadThreadIds;
        this.workers = workers;
        this.queue = queue;
    }

    @Override
    public void run() {
        outer:
        while (true) {
            try {
                while (deadThreadIds.isEmpty()) {
                    synchronized (deadThreadIds) {
                        deadThreadIds.wait();
                    }
                }
                for (Integer id : deadThreadIds) {
                    if (id.equals(-1))
                        break outer;
                    Thread t = new Thread(new Worker(queue,id, deadThreadIds));
                    workers.set(id, t);
                    System.out.println("Birth of new thread with same id " + id);
                    t.start();
                }
                deadThreadIds.clear();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
