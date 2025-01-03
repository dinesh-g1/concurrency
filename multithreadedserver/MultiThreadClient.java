package multithreadedserver;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultiThreadClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MultiThreadedServer multiThreadedServer = new MultiThreadedServer();
        Random random = new Random();
        int numSize = 10000;
        int noOfRequests = 10;
        Map<Integer, FutureTask<Integer>> requestMap = new HashMap<>();

        long start = System.currentTimeMillis();

        //Sending 10 requests to the server
        for (int i = 0; i < noOfRequests; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < numSize; j++) {
                nums.add(random.nextInt(10, 100));
            }
            int equalsTo = random.nextInt(10, 100);
            FutureTask<Integer> task = multiThreadedServer.getPairsEqualsToGivenNumber(nums, equalsTo);
            requestMap.put(i, task);
        }

        for (int i = 0; i < noOfRequests; i++) {
            System.out.println("Request " + i + " have pairs " + requestMap.get(i).get());
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time to process the requests is: " + (end -start));
    }
}
