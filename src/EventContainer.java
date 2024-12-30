public class EventContainer {
    private final EventTitle eventTitle;
    private final EventSyllabus eventSyllabus;

    public EventContainer(EventTitle eventTitle, EventSyllabus eventSyllabus) {
        this.eventTitle = eventTitle;
        this.eventSyllabus = eventSyllabus;
    }

    public void increment() {
        eventTitle.next();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        eventSyllabus.next();
    }

    public String get() {
        return "Title: " + eventTitle.get() + " | Syllabus: " + eventSyllabus.get();
    }
}
