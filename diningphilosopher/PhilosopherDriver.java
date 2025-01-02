package diningphilosopher;

public class PhilosopherDriver {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3 = new Chopstick(3);
        Chopstick c4 = new Chopstick(4);
        Chopstick c5 = new Chopstick(5);
        Thread p1 = new Thread(new Philosopher("one", c1, c2));
        Thread p2 = new Thread(new Philosopher("two", c2, c3));
        Thread p3 = new Thread(new Philosopher("three", c3, c4));
        Thread p4 = new Thread(new Philosopher("four", c4, c5));
        Thread p5 = new Thread(new Philosopher("five", c5, c1));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}
