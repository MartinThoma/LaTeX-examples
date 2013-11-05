public class Euler28 {
    private static void printArray(int[][] spiral, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int getSum(int[][] array, int N) {
        int sum = 0;
        // Summe berechnen
        for (int i = 0; i < N; i++) {
            sum += array[i][i]; // Diagonale 1, links oben nach rechts unten
            sum += array[N - 1 - i][i]; // Diagonale 2, rechts oben nach links
            // unten
        }
        sum -= 1; // die 1 liegt auf beiden Diagonalen
        return sum;
    }

    enum Direction {
        RECHTS, UNTEN, OBEN, LINKS
    }

    public static void main(String[] args) {
        final int N = 5;

        // initialise variables
        int[][] spiral = new int[N][N];
        Direction direction = Direction.RECHTS;
        int posX = N / 2;
        int posY = N / 2;
        int steps = 1;
        int number = 1;

        // fill array with spiral values
        while (number <= N * N) {
            for (int j = 0; j < steps; j++) {

                spiral[posX][posY] = number;

                switch (direction) {
                case RECHTS:
                    posX++;
                    break;
                case UNTEN:
                    posY++;
                    break;
                case LINKS:
                    posX--;
                    break;
                case OBEN:
                    posY--;
                    break;
                }

                number++;
                if (number > N * N) {
                    break;
                }
            }

            switch (direction) {
            case RECHTS:
                direction = Direction.UNTEN;
                break;
            case UNTEN:
                direction = Direction.LINKS;
                steps++;
                break;
            case LINKS:
                direction = Direction.OBEN;
                break;
            case OBEN:
                direction = Direction.RECHTS;
                steps++;
                break;
            }
        }

        printArray(spiral, N);
        System.out.println("Diagonal-Summe: " + getSum(spiral, N));
    }
}
