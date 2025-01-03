package multithreadedserver;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultiThreadedServer {
    public FutureTask<Integer> getPairsEqualsToGivenNumber(List<Integer> numbers, int equalsTo) {
        Callable<Integer> pairCounter = new PairCounter(numbers, equalsTo);
        FutureTask<Integer> task = new FutureTask<>(pairCounter);
        new Thread(task).start();
        return task;
    }
}
