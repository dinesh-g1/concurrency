package multithreadedserver;

import java.util.*;
import java.util.concurrent.FutureTask;

public class SingleThreadClient {
    public static void main(String[] args) {
        SingleThreadServer multiThreadedServer = new SingleThreadServer();
        Random random = new Random();
        int numSize = 10000;
        int noOfRequests = 10;

        long start = System.currentTimeMillis();

        //Sending 10 requests to the server
        for (int i = 0; i < noOfRequests; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < numSize; j++) {
                nums.add(random.nextInt(10, 100));
            }
            int equalsTo = random.nextInt(10, 100);
            int pairs = multiThreadedServer.getNoOfPairsEqualsToGivenNumber(nums, equalsTo);
            System.out.println("No of pairs" + pairs);
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time to process the requests is: " + (end -start));
    }
}
