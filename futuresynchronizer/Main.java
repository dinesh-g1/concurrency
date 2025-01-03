package futuresynchronizer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Person> f = new FutureTask<>(new SimpleCallable());
        new Thread(f).start();
        Person p = null;
        p = f.get();
        if (p != null)
            System.out.println(p.getName() + " : " + p.getCity() + " : " + p.isInterestedInYog());
    }
}
