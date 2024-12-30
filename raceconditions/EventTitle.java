public class EventTitle {
    private String[] titles;
    private int counter;
    public EventTitle() {
        titles = new String[]{"DSA", "LLD", "HLD", "DBMS"};
        counter = 0;
    }
    public void next() {
        counter = (counter+1) % (titles.length);
    }
    public String get() {
        return titles[counter];
    }
}
