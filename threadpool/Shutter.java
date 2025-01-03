package threadpool;

public class Shutter implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Exit the thread pool");
    }
}
