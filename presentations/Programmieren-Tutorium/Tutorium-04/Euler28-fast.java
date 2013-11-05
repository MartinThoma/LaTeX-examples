public class Euler28 {
    public static void main(String[] args) {
        int sum1 = 0, sum2 = 0;
        int n = 3;
        int m = 2;
        for (int i = 0; i < 500; i++) {
            sum1 += (n * n) + ((n * n) - (n - 1));
            n += 2;

            sum2 += (((m * m) + 1) + ((m * m) - (m - 1)));
            m += 2;
        }
        System.out.println("result: " + (sum1 + sum2 + 1));
    }
}
