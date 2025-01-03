package threadpool;

import multithreadedserver.PairCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPool threadPool = new ThreadPool(3);
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();
        Random random = new Random();
        int qty = 10000;
        for (int i = 0; i < 20; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < qty; j++) {
                numbers.add(random.nextInt(10, 100));
            }
            int k = random.nextInt(10, 100);
            FutureTask<Integer> fTask = threadPool.submit(new PairCounter(numbers, k));
            futureTasks.add(fTask);
        }

        for (FutureTask<Integer> ft : futureTasks){
            System.out.println(ft.get());
        }
    }
}
