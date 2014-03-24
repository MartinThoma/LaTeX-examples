/* @author Axel Busch */
public class SingleCorePrimeTest {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int target = 10_000_000;
        long start = System.currentTimeMillis();
        for (int i = 2; i <= target; ++i) {
            isPrime(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
}