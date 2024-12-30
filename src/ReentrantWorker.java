public class ReentrantWorker implements Runnable{
    private final EventContainer container;

    public ReentrantWorker(EventContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        container.increment();
    }
}
