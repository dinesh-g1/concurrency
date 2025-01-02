package diningphilosopher;

public class Philosopher implements Runnable{
    private final String name;
    private final Chopstick left, right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(2000);
                System.out.println(name + " is thinking.");
                Chopstick c1, c2;
                if (left.getId() < right.getId()) {
                    c1 = left;
                    c2 = right;
                } else {
                    c1 = right;
                    c2 = left;
                }
                synchronized (c1) {
                    System.out.println(name + " picked up left chopstick.");
                    Thread.sleep(2000);
                    synchronized (c2) {
                        System.out.println(name + " picked up right chopstick.");
                        Thread.sleep(2000);
                        System.out.println(name + " is eating.");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
