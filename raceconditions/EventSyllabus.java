public class EventSyllabus {
    private final String[] syllabuses;
    private int counter;
    public EventSyllabus() {
        syllabuses = new String[]{"Arrays, Maps, Graphs", "SOLID and Design Patterns", "Micro services and monoliths", "Queries"};
        counter = 0;
    }

    public void next() {
        counter = (counter+1) % syllabuses.length;
    }

    public String get() {
        return syllabuses[counter];
    }
}
