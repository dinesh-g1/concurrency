package latch;

public class TotalSum {
    private int sum;

    public TotalSum() {
        this.sum = 0;
    }

    public synchronized void add(int chunkSum) {
        sum += chunkSum;
    }

    public int getSum() {
        return sum;
    }
}
