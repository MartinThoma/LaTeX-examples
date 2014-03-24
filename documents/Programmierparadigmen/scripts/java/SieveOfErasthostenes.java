import java.util.Arrays;

public class SieveOfErasthostenes {

    public static boolean[] sieveIt(int n) {
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i=2; i <= Math.sqrt(n); i++) {
            if (sieve[i]) {
                for (int c = i*i; c <= n; c += i) {
                    sieve[c] = false;
                }
            }
        }
        return sieve;
    }

    public static void main(String[] args) {
        final int n = 100_000_000;
        final long startTime = System.currentTimeMillis();
        sieveIt(n);
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}