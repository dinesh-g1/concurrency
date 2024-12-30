package sorting;

public class Worker implements Runnable{
    private final int val;

    public Worker(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        while (val > SortedThreadsDriver.curr) {}
        System.out.println(val);
        SortedThreadsDriver.curr++;
    }
}
