import java.util.Scanner;

public class SeaBattleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Welcome to Sea Battle!");

        boolean isPlayer1Turn = true;
        while (player1.hasShipsRemaining() && player2.hasShipsRemaining()) {
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            Player opponentPlayer = isPlayer1Turn ? player2 : player1;

            GameUtils.clearConsole();
            System.out.println("\n" + (isPlayer1Turn ? "Player 1's turn:" : "Player 2's turn:"));

            System.out.println("Your board:");
            currentPlayer.displayBoard(false);

            System.out.println("Opponent's board:");
            opponentPlayer.displayBoard(true);

            System.out.print("Enter attack coordinates (row and column): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean validAttack = opponentPlayer.attack(x, y);
            if (validAttack) {
                if (!opponentPlayer.hasShipsRemaining()) {
                    GameUtils.clearConsole();
                    System.out.println((isPlayer1Turn ? "Player 1" : "Player 2") + " wins!");
                    break;
                }
            }

            isPlayer1Turn = !isPlayer1Turn;
        }

        scanner.close();
    }
}
