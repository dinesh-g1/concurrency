package threadwaiting;

public class TickingBoardDriver {
    public static void main(String[] args) {
        TickingBoard tickingBoard = new TickingBoard();
        Object lock = new Object();
        for (int i = 1; i < 10; i++) {
            Customer customer = new Customer(tickingBoard, i, lock);
            Thread customerThread = new Thread(customer);
            customerThread.start();
        }
    }
}
