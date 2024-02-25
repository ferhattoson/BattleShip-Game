
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class BattleshipGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player1 = createPlayer("Player 1", scanner);
        Player player2 = createPlayer("Player 2", scanner);
        Board board1 = new Board(10, 10);
        player1.setBoard(board1);
        board1.placeShipsRandomly();
        Board board2 = new Board(10, 10);
        player2.setBoard(board2);
        board2.placeShipsRandomly();
        boolean gameOver = false;
        Player currentPlayer = player1;
        Player otherPlayer = player2;
        Set<String> enteredCoordinates = new HashSet<>();
        while (!gameOver) {
            System.out.println(currentPlayer.getName()+" board:   ");
            System.out.println(currentPlayer.getBoard()+" ");
            System.out.println(otherPlayer.getName()+" board:     ");
            System.out.println(otherPlayer.getBoard());
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = -1, col = -1;
            boolean validInput = false;
            do {
                System.out.print("Enter row and column coordinates (Example: 3 4): ");
                String input = scanner.nextLine();
                String[] coordinates = input.split(" ");
                if (coordinates.length != 2) {
                    System.out.println("Invalid input. Try again:");
                    continue;
                }
                try {
                    row = Integer.parseInt(coordinates[0]);
                    col = Integer.parseInt(coordinates[1]);
                    if (enteredCoordinates.contains(input)) {
                        System.out.println("You already entered these coordinates. It's your opponent's turn.");
                    } else {
                        validInput = true;
                        enteredCoordinates.add(input);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again:");
                }
            } while (!validInput || row < 0 || row >= 10 || col < 0 || col >= 10);





            currentPlayer.takeTurn(row, col);
            if (player1.allShipsSunk() || player2.allShipsSunk()) {
                gameOver = true;
            }
            if (!gameOver) {
                Player temp = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = temp;
            }
        }
        if (player1.allShipsSunk()) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }
    private static Player createPlayer(String defaultName, Scanner scanner) {
        System.out.print("Enter name for " + defaultName + ": ");
        String playerName = scanner.nextLine();
        return new Player(playerName);
    }

}
