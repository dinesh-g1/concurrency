import java.util.ArrayList;

public class Worker implements Runnable{
    private final int l, r;
    private final ArrayList<Integer> nums;
    public Worker(ArrayList<Integer> nums, int l, int r) {
        this.l = l;
        this.r = r;
        this.nums = nums;
    }

    @Override
    public void run() {
        long workerSum = 0;
        for (int i = l; i <= r; i++)
            workerSum += nums.get(i);
        ConcurrentDriver.sum.addAndGet(workerSum);
        ConcurrentDriver.cnt.incrementAndGet();
    }
}
