public class ReentrantDriver {
    public static void main(String[] args) throws InterruptedException {
        EventTitle eventTitle = new EventTitle();
        EventSyllabus eventSyllabus = new EventSyllabus();
        EventContainer container = new EventContainer(eventTitle, eventSyllabus);
        System.out.println(container.get());
        Thread one = new Thread(new ReentrantWorker(container));
        one.start();
        Thread.sleep(2000);
        System.out.println(container.get());
    }
}
