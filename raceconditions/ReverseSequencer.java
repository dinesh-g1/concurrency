public class ReverseSequencer implements Runnable{
    @Override
    public void run() {
        for (int i = 9; i >= 0; i--) {
            System.out.print("rs-" + i + " ");
        }
    }
}
