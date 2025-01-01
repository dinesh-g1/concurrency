package deadlock;

public class DeadLockDriver {
    public static void main(String[] args) {
        Object one = new Object();
        Object two = new Object();
        Thread t1 = new Thread(new Run1(one, two));
        Thread t2 = new Thread(new Run2(one, two));

        t1.start();
        t2.start();
    }
}
