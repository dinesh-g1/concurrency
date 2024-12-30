package sorting;

public class SortedThreadsDriver {
    public static volatile int curr = 1;
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Worker(i));
            t.start();
        }
    }
}
