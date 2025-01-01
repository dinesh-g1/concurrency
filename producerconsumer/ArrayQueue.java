package producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue {
    private final List<Integer> queue;
    private int front;
    private int rear;
    private final int limit;

    public ArrayQueue(int limit) {
        this.limit = limit;
        this.queue = new ArrayList<>();
        this.front = -1;
        this.rear = 0;
    }

    public boolean isFull() {
        return (front - rear + 1 == limit);
    }

    public boolean isEmpty() {
        return rear > front;
    }

    public void push(int num) {
        if (isFull())
            throw new RuntimeException("Queue is full...");
        queue.add(num);
        front++;
    }

    public Integer pop() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty...");
        return queue.get(rear++);
    }
}
