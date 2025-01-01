package producerconsumer;

import java.util.ArrayDeque;

public class Consumer implements Runnable{
    private final ArrayDeque<Integer> queue;

    public Consumer(ArrayDeque<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Integer num = queue.removeLast();
                    queue.notify();
                    System.out.println("Consumed from the queue: " + num);
                    if (num == -1)
                        break;
                }
            }
        }
    }
}
