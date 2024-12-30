public class NumberStore {
    private int w,x,y,z;

    public NumberStore() {
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public synchronized void increment() {
        w++;
        x++;
        y++;
        z++;
    }
    public synchronized int getW() {
        return w;
    }

    public synchronized int getX() {
        return x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized int getZ() {
        return z;
    }
}