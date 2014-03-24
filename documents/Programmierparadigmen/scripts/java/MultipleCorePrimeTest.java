import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MultipleCorePrimeTest {
    public static void count(int target, int threads) 
      throws InterruptedException, TimeoutException {
        ExecutorService executor =
            Executors.newFixedThreadPool(threads);
        List<FutureTask<Integer>> taskList = 
            new ArrayList<FutureTask<Integer>>();
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= threads; ++i) {
            int ilen = target / threads;

            /* Test following intervall for primes */
            final int start = (i - 1) * ilen;
            final int end = (i != threads) 
                            ? i * ilen - 1 
                            : target;
            FutureTask<Integer> task = 
                new FutureTask<Integer>(
                  new Callable<Integer>() {
                    @Override
                    public Integer call() {
                        int count = 0;
                        for (int i = start; i <= end; 
                                            ++i) {
                            if (SingleCorePrimeTest.
                                  isPrime(i))
                                ++count;
                        }
                        return count;
                    }
                });
            taskList.add(task);
            executor.submit(task);
        }

        executor.shutdown();
        if (!executor.awaitTermination(10, 
            TimeUnit.MINUTES)) {
                throw new TimeoutException();
        }
        final long endTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < taskList.size(); ++i) {
            try {
                count += taskList.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threads + " thread: "
            + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        final int target = 100_000_000;
        try {
            count(target, 1);
            count(target, 2);
            count(target, 4);
            count(target, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}