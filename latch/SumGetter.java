package latch;

public class SumGetter implements Runnable{
    private final CountDownLatch countDownLatch;
    private final TotalSum totalSum;

    public SumGetter(CountDownLatch countDownLatch, TotalSum totalSum) {
        this.countDownLatch = countDownLatch;
        this.totalSum = totalSum;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total sum: " + totalSum.getSum());
    }
}
