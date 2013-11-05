public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(f.getFunctionValue(i));
        }

        /* Fehlerbehandlung */
        try {
            f.getFunctionValue(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("Your Error: ");
            System.out.println(e);
        }
    }

}

