public class IataCode {
    public static void printIATACodes(String[] myArray) {
        for (int i = 0; i < myArray.length; i += 3) {
            System.out.println(myArray[i]);
        }
    }

    public static void main(String[] args) {
        String[] iataCodes = { "MUC", "BER", "AGB", "ABC", "DEF",
                "GIH", "JKL", "MNO", "PQR", "STU", "VWX", "YZ" };
        printIATACodes(iataCodes);
    }
}
