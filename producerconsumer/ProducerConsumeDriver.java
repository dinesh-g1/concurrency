package producerconsumer;

import java.util.ArrayDeque;

public class ProducerConsumeDriver {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Thread producer = new Thread(new Producer(queue, 10));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}
