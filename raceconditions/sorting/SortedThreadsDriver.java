package sorting;

public class SortedThreadsDriver {
    public static int curr = 1;
    public static void main(String[] args) {
        Object lock = new Object();
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Worker(i, lock));
            t.start();
        }
    }
}
