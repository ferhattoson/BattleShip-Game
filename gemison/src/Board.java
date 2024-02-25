import java.util.Random;

public class Board {
    private Square[][] board; //tahta
    private int rowCount = 10; //satır sayısı
    private int columnCount = 10; //sütun sayısı
    private int smallBattleshipsCount = 0;
    private int mediumBattleshipsCount = 0;
    private int largeBattleshipsCount = 0;

    public int getSmallBattleshipsCount() {
        return smallBattleshipsCount;
    }

    public int getMediumBattleshipsCount() {
        return mediumBattleshipsCount;
    }

    public int getLargeBattleshipsCount() {
        return largeBattleshipsCount;
    }

    public Board(int lineCount, int columnCount) {
        this.rowCount = lineCount;
        this.columnCount = columnCount;
        board = new Square[lineCount][columnCount];
        initializeBoard();
        placeShipsRandomly();
    }

    public Square getSquare(int row, int column) {
        if (row >= 0 && row < rowCount && column >= 0 && column < columnCount) {
            return board[row][column];
        }
        return null;
    }
    public void initializeBoard() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                board[i][j] = new Square(i, j);
            }
        }
    }

    public void placeShipsRandomly() {
        Random random = new Random();
        for (int i = 0; i < SmallBattleship.TOTAL_SHIPS; i++) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(rowCount);
                int col = random.nextInt(columnCount);
                Square Square = getSquare(row, col);

                if (!Square.containsShip()) {
                    Square.setGemi(new SmallBattleship());
                    Square.setGemiVarMi(true);
                    placed = true;
                    smallBattleshipsCount++;
                }
            }
        }
        for (int i = 0; i < LargeBattleship.TOTAL_SHIPS; i++) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(rowCount);
                int col = random.nextInt(columnCount);
                Square Square = getSquare(row, col);

                if (!Square.containsShip()) {
                    Square.setGemi(new LargeBattleship());
                    Square.setGemiVarMi(true);
                    placed = true;
                    largeBattleshipsCount++;
                }
            }
        }
        for (int i = 0; i < MediumBattleship.TOTAL_SHIPS; i++) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(rowCount);
                int col = random.nextInt(columnCount);
                Square Square = getSquare(row, col);

                if (!Square.containsShip()) {
                    Square.setGemi(new MediumBattleship());
                    Square.setGemiVarMi(true);
                    placed = true;
                    mediumBattleshipsCount++;
                }
            }
        }
    }
    public void decreaseSmallBattleshipsCount() {
        smallBattleshipsCount--;
    }

    public void decreaseMediumBattleshipsCount() {
        mediumBattleshipsCount--;
    }

    public void decreaseLargeBattleshipsCount() {
        largeBattleshipsCount--;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  0 1 2 3 4 5 6 7 8 9 \n");

        for (int i = 0; i < rowCount; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < columnCount; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean allShipsSunk() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (board[i][j].containsShip() && !board[i][j].isHit()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print(getSquare(i, j) + " ");
            }
            System.out.println();
        }
    }
}
