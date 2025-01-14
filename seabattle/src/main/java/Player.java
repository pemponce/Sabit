import java.util.Random;

class Player implements GameUtils {
    private final char[][] board;
    private int remainingShips;

    public Player() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.remainingShips = 3;
        initializeBoard();
        placeShips();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '~';
            }
        }
    }

    private void placeShips() {
        Random random = new Random();
        int placedShips = 0;
        while (placedShips < 3) {
            int x = random.nextInt(BOARD_SIZE);
            int y = random.nextInt(BOARD_SIZE);
            if (board[x][y] == '~') {
                board[x][y] = 'S';
                placedShips++;
            }
        }
    }

    public boolean attack(int x, int y) {
        if (!isValidCoordinate(x, y)) {
            System.out.println("Invalid coordinates! Try again.");
            return false;
        }
        if (board[x][y] == 'S') {
            board[x][y] = 'X';
            remainingShips--;
            System.out.println("Hit!");
            return true;
        } else if (board[x][y] == '~') {
            board[x][y] = 'O';
            System.out.println("Miss!");
            return false;
        } else {
            System.out.println("Already attacked this position. Try again.");
            return false;
        }
    }

    public boolean hasShipsRemaining() {
        return remainingShips > 0;
    }

    public void displayBoard(boolean hideShips) {
        GameUtils.printBoard(board, hideShips);
    }
}