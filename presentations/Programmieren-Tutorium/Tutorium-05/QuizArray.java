public class QuizArray {
    public static void main(String[] args) {
        String[] myArray1 = { " geh ", "du", "alter", "esel" };
        String[] myArray2 = myArray1;
        myArray2[3] = "sack";

        System.out.print("myArray1: ");
        for (int i = 0; i < myArray1.length; i++) {
            System.out.print(myArray1[i] + " ");
        }

        System.out.print("\nmyArray2: ");
        for (int i = 0; i < myArray2.length; i++) {
            System.out.print(myArray2[i] + " ");
        }
    }
}
