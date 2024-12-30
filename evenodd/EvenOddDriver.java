package evenodd;

public class EvenOddDriver {
    public static final int limit = 20;
    public static int curr = 1;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread odd = new Thread(new OddWorker("odd", lock));
        Thread even = new Thread(new EvenWorker("even", lock));
        odd.start();
        even.start();
    }
}
