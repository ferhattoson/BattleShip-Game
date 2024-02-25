import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player otherPlayer;
    private Board board;

    public Game() {
        board = new Board(10, 10);
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        player1.setBoard(board);
        player2.setBoard(board);
        currentPlayer = player1;
        otherPlayer = player2;
    }

    public void initializePlayers() {
        Scanner scanner = new Scanner(System.in);

        // Player 1 isminin alınması
        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        player1.setName(player1Name);

        // Player 2 isminin alınması
        System.out.print("Enter name for Player 2: ");
        String player2Name = scanner.nextLine();
        player2.setName(player2Name);
    }

    public void play() {
        initializePlayers();
        System.out.println("Game started! " + player1.getName() + " vs " + player2.getName());

        while (true) {
            System.out.println(currentPlayer.getName() + ", choose target (Example: 3 4): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] coordinates = input.split(" ");

            if (coordinates.length != 2) {
                System.out.println("Invalid input. Try again:");
                continue;
            }

            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);

            boolean gameEnded = currentPlayer.takeTurn(row, column);

            if (gameEnded) {
                System.out.println(currentPlayer.getName() + " wins!");
                System.out.println("Points: " + player1.getName() + " - " + player1.getPuan() + ", " +
                        player2.getName() + " - " + player2.getPuan());
                break;
            }

            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
