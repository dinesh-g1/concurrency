package multithreadedserver;

import java.util.List;

public class SingleThreadServer {
    public int getNoOfPairsEqualsToGivenNumber(List<Integer> numbers, int equalsTo) {
        int size = numbers.size();
        int pairs = 0;
        for (int i = 0; i < size; i++) {
            int curI = numbers.get(i);
            for (Integer number : numbers) {
                if (number + curI == equalsTo) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
