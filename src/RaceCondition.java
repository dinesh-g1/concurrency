public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        NumberWrapper nw = new NumberWrapper();
        Thread one = new Thread(new RaceWorker(nw));
        Thread two = new Thread(new RaceWorker(nw));

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(nw.getX());
    }
}
