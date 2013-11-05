public class ConnectFourGame implements Cloneable {
    private Color[][] board = new Color[7][6];
    private Color lastMove;
    private Color winner;
    private boolean isFinished = false;

    //[...]

    public void printBoard() {
        for (byte y = 5; y >= 0; y--) {
            System.out.print(y + " ");
            for (byte x = 0; x < 7; x++) {
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
        for (byte x = 0; x < 7; x++) {
            System.out.print(x);
        }
    }
}
