package threadpool;

public class ThreadDier implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException("Make the thread die");
    }
}
