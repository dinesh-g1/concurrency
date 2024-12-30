import java.util.Map;

public class Main {
    public static void main(String[] args) {
        long sum = 0;
        Thread seq = new Thread(new Sequencer());
        Thread revSeq = new Thread(new ReverseSequencer());
        seq.start();
        revSeq.start();

        for (int i = 100; i < 110; i++) {
            System.out.print("m-" + i + " ");
        }
    }
}