unsigned int getFirstIndex(char board[BOARD_WIDTH][BOARD_HEIGHT]) {
    unsigned int index = 0;
    for (int x=0; x<BOARD_WIDTH; x++) {
        for (int y=0; y<BOARD_HEIGHT; y++) {
            index += charToInt(board[x][y])*myPow(3, ((x+y*BOARD_WIDTH)%HASH_MODULO));
        }
    }
    index = index % MAXIMUM_SITUATIONS;
    return index;
}
