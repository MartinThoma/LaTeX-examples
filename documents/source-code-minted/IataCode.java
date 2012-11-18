public class IataCode {
    public static void printIATACodes(String[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    public static void main(String[] args) {
        String[] iataCodes = new String[4];
        // Flughafen München
        iataCodes[0] = "MUC";
        // Flughafen Berlin Brandenburg
        iataCodes[1] = "BER";
        // Flughafen Augsburg
        iataCodes[2] = "AGB";
        printIATACodes(iataCodes);
    }
}
