package threadwaiting;

public class Customer implements Runnable {
    private final TickingBoard tickingBoard;
    private final int customerId;
    private final Object lock;

    public Customer(TickingBoard tickingBoard, int customerId, Object lock) {
        this.tickingBoard = tickingBoard;
        this.customerId = customerId;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!isReady()) {
            System.out.println("customer id " + customerId + " waiting for appointment");
            synchronized (lock) {
                try {
                    lock.wait(1000, 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (lock) {
            System.out.println("customer id " + customerId + " got the appointment");
            lock.notifyAll();
        }
    }

    private boolean isReady() {
        synchronized (lock) {
            return  tickingBoard.nextAppointment(customerId);
        }
    }
}
