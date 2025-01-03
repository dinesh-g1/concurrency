package multithreadedserver;

import java.util.List;
import java.util.concurrent.Callable;

public class PairCounter implements Callable<Integer> {
    private final List<Integer> numbers;
    private final int pairSumEqualsTo;
    private int pairs;

    public PairCounter(List<Integer> numbers, int pairSumEqualsTo) {
        this.numbers = numbers;
        this.pairSumEqualsTo = pairSumEqualsTo;
        this.pairs = 0;
    }

    @Override
    public Integer call() throws Exception {
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            int curI = numbers.get(i);
            for (Integer number : numbers) {
                if (number + curI == pairSumEqualsTo) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
