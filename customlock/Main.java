package customlock;

public class Main {
    public static void main(String[] args) {
        CustomLock lock = new CustomLock();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Worker(lock));
            t.start();
        }
    }
}
