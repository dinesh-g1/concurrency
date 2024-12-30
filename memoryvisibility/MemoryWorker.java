public class MemoryWorker implements Runnable{

    private final NumberStore numberStore;

    public MemoryWorker(NumberStore numberStore) {
        this.numberStore = numberStore;
    }

    @Override
    public void run() {
        numberStore.increment();
    }
}
