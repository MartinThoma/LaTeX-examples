import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] myStrings = new String[5];
        myStrings[0] = "I";
        myStrings[1] = "think";
        myStrings[2] = "therefore";
        myStrings[3] = "I";
        myStrings[4] = "am";

        System.out.println(Arrays.asList(myStrings));
        Arrays.sort(myStrings);
        System.out.println(Arrays.asList(myStrings));
    }
}
