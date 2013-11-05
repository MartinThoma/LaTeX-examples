public class IataCode {
    public static void printIATACodes(String[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[myArray.length - i - 1]);
        }
    }

    public static void main(String[] args) {
        String[] iataCodes = new String[4];
        iataCodes[0] = "MUC";
        iataCodes[1] = "BER";
        iataCodes[2] = "AGB";
        printIATACodes(iataCodes);
    }
}
