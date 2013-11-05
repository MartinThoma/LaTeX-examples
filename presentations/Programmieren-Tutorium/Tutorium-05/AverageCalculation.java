public class AverageCalculation {
    public static float getAverage(int[] numbers) {
        float sum = 0.0f;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(getAverage(numbers));
    }
}
