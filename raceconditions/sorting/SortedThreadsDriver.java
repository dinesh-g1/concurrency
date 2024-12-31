package sorting;

public class SortedThreadsDriver {
    public static int curr = 1;
    public static void main(String[] args) {
            Object lock = new Object();
            for (int j = 1; j <= 10; j++) {
                Thread t = new Thread(new Worker(j, lock));
                t.start();
            }
    }
}
