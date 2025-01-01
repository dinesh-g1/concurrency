package producerconsumer;

import java.util.ArrayDeque;

public class Producer implements Runnable{
    private final ArrayQueue queue;

    public Producer(ArrayQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            synchronized (queue) {
                if (queue.isFull()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    queue.push(i);
                    System.out.println("Produced to queue: " + i);
                    if (i == 50) {
                        // To break the looping of consumer we produce the -1 to indicate this is the last
                        // message to consume in the Queue.
                        queue.push(-1);
                        System.out.println("Produced to queue: " + -1);
                    }
                    queue.notify();
                }
            }
        }
    }
}
