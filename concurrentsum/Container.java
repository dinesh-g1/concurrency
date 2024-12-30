package concurrentsum;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<Integer> nums;
    private int idx;

    public Container() {
        nums = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            nums.add(i);
        }
        idx = 0;
    }

    public synchronized int  pluck() {
        if (idx == nums.size())
            return -1;
        int num = nums.get(idx);
        idx++;
        return num;
    }
}
