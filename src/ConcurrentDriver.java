import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentDriver {
    public static AtomicLong sum = new AtomicLong(0);
    public static AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++)
            nums.add(random.nextInt());

        long seqStart = System.currentTimeMillis();
        sequentialSum(nums);
        long seqEnd = System.currentTimeMillis();

        System.out.println("Sequential time taken for the sum: " + (seqEnd - seqStart));

        long conStart = System.currentTimeMillis();
        concurrentSum(nums);
        long conEnd = System.currentTimeMillis();

        System.out.println("Concurrent time taken for the sum: " + (conEnd - conStart));
    }

    public static void sequentialSum(ArrayList<Integer> nums) {
        long seqSum = 0;
        for (Integer n : nums) {
            seqSum += n;
        }
        System.out.println("Total sequential seqSum: " + seqSum);
    }

    public static void concurrentSum(ArrayList<Integer> nums) {
        int size = nums.size()/8;
        Thread one = new Thread(new Worker(nums, 0, size-1));
        Thread two = new Thread(new Worker(nums, size, 2 * size - 1));
        Thread three = new Thread(new Worker(nums, 2 * size, 3 * size - 1));
        Thread four = new Thread(new Worker(nums, 3 * size, 4 * size - 1));

        one.start();
        two.start();
        three.start();
        four.start();

        while (cnt.get() < 4) {}

        System.out.println("Total concurrent sum: " + sum.get());
    }
}
