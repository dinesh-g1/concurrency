public class NumberWrapper {
    private int x;
    public NumberWrapper() {
        x = 0;
    }
//    public void inc() {
//            x++;
//    }
    public synchronized int getX() {
        return x;
    }
    public synchronized void setX(int x) {
        this.x = x;
    }
}
