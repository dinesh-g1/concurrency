package concurrentsum;

public class ConcurrentSumDriver {
    public static int sum = 0;
    public static void main(String[] args) {
        Container container = new Container();
        Object lock = new Object();
        for (int i = 1; i < 100; i++) {
            Thread t = new Thread(new PluckAndAddWorker(container, lock));
            t.start();
        }
        System.out.println(sum);
    }
}
