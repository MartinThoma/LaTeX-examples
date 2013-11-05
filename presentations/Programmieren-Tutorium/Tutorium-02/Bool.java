public class Bool {
    public static void main(String[] v) {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        int d = 0;
        boolean e = false;

        if (a && b && c) {
            System.out.println("Alpha");
        }

        if (d) {
            System.out.println("Beta");
        }

        if (a||b && b||e) {
            System.out.println("Gamma");
        }
    }
}
