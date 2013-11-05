public class World {
    public static void main(String[] args) {
        int[] myArray = { 1, 5, 6, 23, 4, 2, -1, 4 };

        // for-Schleife
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        // foreach-Schleife
        for (int element : myArray) {
            System.out.println(element);
        }
    }
}
