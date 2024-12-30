package evenodd;

public class EvenOddDriver {
    public static final int limit = 20;
    public static int curr = 1;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread odd1 = new Thread(new OddWorker("odd1", lock));
        Thread odd2 = new Thread(new OddWorker("odd2", lock));
        Thread even1 = new Thread(new EvenWorker("even1", lock));
        Thread even2 = new Thread(new EvenWorker("even2", lock));
        odd1.start();
        odd2.start();
        even1.start();
        even2.start();
    }
}
