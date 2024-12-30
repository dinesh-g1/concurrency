public class RaceWorker implements Runnable {
    private NumberWrapper numberWrapper;
    public RaceWorker(NumberWrapper numberWrapper) {
        this.numberWrapper = numberWrapper;
    }
    @Override
    public void run() {
            for (int i = 0; i < 1000000; i++) {
                synchronized (numberWrapper) {
                    int oldVal = numberWrapper.getX();
                    numberWrapper.setX(oldVal + 1);
                }
            }
    }
}
