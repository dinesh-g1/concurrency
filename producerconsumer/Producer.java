package producerconsumer;

import java.util.ArrayDeque;

public class Producer implements Runnable{
    private final ArrayDeque<Integer> queue;
    private final int limit;

    public Producer(ArrayDeque<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            synchronized (queue) {
                if (queue.size() == limit) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    queue.addFirst(i);
                    System.out.println("Produced to queue: " + i);
                    if (i == 20) {
                        // To break the looping of consumer we produce the -1 to indicate this is the last
                        // message to consume in the Queue.
                        queue.addFirst(-1);
                        System.out.println("Produced to queue: " + -1);
                    }
                    queue.notify();
                }
            }
        }
    }
}
