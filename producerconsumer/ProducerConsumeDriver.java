package producerconsumer;

import java.util.ArrayDeque;

public class ProducerConsumeDriver {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}
