public class QuizString {
    public static void main(String[] args) {
        String string1 = new String("Hallo");
        String string2 = new String("Hallo");
        if (string1 == string2) {
            System.out.println("string1 und string2 sind das selbe Objekt.");
        } else {
            System.out.println("string1 und string2 sind verschiedene Objekte.");
        }

        String string3 = "Hallo";
        String string4 = "Hallo";
        if (string3 == string4) {
            System.out.println("string3 und string4 sind das selbe Objekt.");
        } else {
            System.out.println("string3 und string4 sind verschiedene Objekte.");
        }
    }
}

