interface GameUtils {
    int BOARD_SIZE = 5;

    static void printBoard(char[][] board, boolean hideShips) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (hideShips && board[i][j] == 'S') {
                    System.out.print("~ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    default boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}