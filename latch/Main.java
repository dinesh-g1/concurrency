package latch;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        List<Integer> numbers = new ArrayList<>();
        TotalSum totalSum = new TotalSum();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        int size = 25;
        Thread chunk1 = new Thread(new Adder(0, size-1, numbers,totalSum , countDownLatch));
        Thread chunk2 = new Thread(new Adder(size, 2*size-1, numbers,totalSum , countDownLatch));
        Thread chunk3 = new Thread(new Adder(2*size, 3*size-1, numbers,totalSum , countDownLatch));
        Thread chunk4 = new Thread(new Adder(3*size, 4*size-1, numbers,totalSum , countDownLatch));

        Thread getSum = new Thread(new SumGetter(countDownLatch, totalSum));

        getSum.start();
        chunk1.start();
        chunk2.start();
        chunk3.start();
        chunk4.start();
    }
}
