public class Sum implements Runnable {
    private final int UpperEnd;

    public Sum(int upperEnd) {
        UpperEnd = upperEnd;
    }

    @Override
    public void run() {
        for (int i = 0; i < UpperEnd; i++) {
            Main.bigSum++;
        }
    }
}
