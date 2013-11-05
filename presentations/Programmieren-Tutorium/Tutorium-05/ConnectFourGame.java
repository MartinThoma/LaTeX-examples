public class ConnectFourGame implements Cloneable {
    public static final int BOARD_HEIGHT = 6;
    public static final int BOARD_WIDTH = 7;
    public static final int WINNING_NR = 4;

    private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];
    private Color lastMove;
    private Color winner;
    private boolean isFinished = false;

    //[...]

    public void printBoard() {
        for (byte y = BOARD_HEIGHT - 1; y >= 0; y--) {
            System.out.print(y + " ");
            for (byte x = 0; x < BOARD_WIDTH; x++) {
                if (board[x][y] == null) {
                    System.out.print(" ");
                } else if (board[x][y] == Color.RED) {
                    System.out.print("r");
                } else {
                    System.out.print("w");
                }
            }
            System.out.println("");
        }
        System.out.print("  ");
        for (byte x = 0; x < BOARD_WIDTH; x++) {
            System.out.print(x);
        }
    }
}
