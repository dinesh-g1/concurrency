package sorting;

public class SortedThreadsDriver {
    public static int curr = 1;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Object lock = new Object();
            for (int j = 0; j < 10; j++) {
                Thread t = new Thread(new Worker(j, lock));
                t.start();
                t.join();
            }
            System.out.println();
        }
    }
}
