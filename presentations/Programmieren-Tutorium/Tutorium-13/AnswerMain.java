import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static final int BIG_NR = 2000000;
    public static AtomicLong bigSum = new AtomicLong();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 50; i++) {
            Runnable task = new Sum(BIG_NR);
            Thread worker = new Thread(task);
            worker.start();
            threads.add(worker);
        }

        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }
            System.out.println("Remaining threads: " + running);
        } while (running > 0);

        System.out.println(Main.bigSum);

    }
}
