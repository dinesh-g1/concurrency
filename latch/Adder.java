package latch;

import java.util.List;

public class Adder implements Runnable{
    private final int start, end;
    private final TotalSum totalSum;
    private final CountDownLatch countDownLatch;
    private final List<Integer> numbers;

    public Adder(int start, int end, List<Integer> numbers, TotalSum totalSum, CountDownLatch countDownLatch) {
        this.start = start;
        this.end = end;
        this.totalSum = totalSum;
        this.countDownLatch = countDownLatch;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int chunkSum = 0;
        for (int i = start; i <= end; i++) {
            chunkSum += numbers.get(i);
        }
        totalSum.add(chunkSum);
        countDownLatch.countDown();
    }
}
