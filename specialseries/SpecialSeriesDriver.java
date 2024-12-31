package specialseries;

public class SpecialSeriesDriver {
    protected static final int n = 6;
    protected static int i = 0, reset = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));
        Thread zero = new Thread(new Zero(lock));
        even.start();
        odd.start();
        zero.start();
    }
}
