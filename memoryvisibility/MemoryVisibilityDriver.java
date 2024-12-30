public class MemoryVisibilityDriver {
    public static void main(String[] args) throws InterruptedException {
        NumberStore numberStore = new NumberStore();
        for (int i = 0; i < 100000; i++) {
            Thread t = new Thread(new MemoryWorker(numberStore));
            int curZ = numberStore.getZ();
            t.start();
            while (curZ == numberStore.getZ()) {}
            System.out.println();
            if (!(numberStore.getW() == numberStore.getX() &&
                    numberStore.getX() == numberStore.getY() &&
                    numberStore.getY() == numberStore.getZ())) {
                System.out.println(numberStore.getW() + " " +
                        numberStore.getX() + " " +
                        numberStore.getY() + " " +
                        numberStore.getZ());
            }
            System.out.printf("%d, %d, %d, %d", numberStore.getW(),numberStore.getX(), numberStore.getY(),numberStore.getZ());
            t.join();
        }
    }
}
