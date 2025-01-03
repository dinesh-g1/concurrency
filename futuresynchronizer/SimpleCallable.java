package futuresynchronizer;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<Person> {
    @Override
    public Person call() throws Exception {
        //Sleeping is replicated to getting the person details from the DB.
        Thread.sleep(2000);
        return new Person("Dinesh", "BhagyaNagar", true);
    }
}
