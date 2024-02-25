import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {
    private Board board;
    private String name;
    private int point;
    String hitSoundFilePath = "assets/success.wav";
    String missSoundFilePath = "assets/error.wav";

    public Player(String name) {
        this.name = name;
    }

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
        this.point = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public boolean takeTurn(int row, int column) {
        Square square = board.getSquare(row, column);

        if (square.isAtisYapildiMi()) {
            System.out.println(name + "'s coordinate (" + row + ", " + column + ") has already been fired upon.");
        } else {
            square.setAtisYapildiMi(true);

            if (square.isGemiVarMi()) {
                Battleship gemi = square.getGemi();
                gemi.decreaseHealth();

                if (gemi.sunk()) {
                    playSound(hitSoundFilePath);
                    System.out.println(getName() + " tarafından " + gemi.getSize() + " birimlik bir gemi batırıldı!");
                    point++;
                } else {
                    playSound(hitSoundFilePath);
                    System.out.println(getName() + " tarafından bir gemi vuruldu!");
                }
            } else {
                playSound(missSoundFilePath);
                System.out.println(getName() + "'s coordinate (" + row + ", " + column + ") resulted in a miss!");
            }
        }

        return allShipsSunk();
    }*/
   public boolean takeTurn(int satir, int sutun) {
       Square kare = board.getSquare(satir, sutun);

       if (kare.isAtisYapildiMi()) {
           System.out.println("Bu kareye daha önce ateş ettiniz. Lütfen başka bir kare seçin.");
           return false;
       }

       kare.setAtisYapildiMi(true);

       if (kare.isGemiVarMi()) {
           Battleship gemi = kare.getGemi();
           if (gemi != null) { // Gemi nesnesinin null olup olmadığını kontrol edin
               gemi.decreaseHealth();

               if (gemi.isSunk()) {
                   playSound(hitSoundFilePath);
                   System.out.println(getName() + " tarafından " + gemi.getSize() + " birimlik bir gemi batırıldı!");
                   point++;
               } else {
                   playSound(hitSoundFilePath);
                   System.out.println(getName() + " tarafından bir gemi vuruldu!");
               }

               return gemi.isSunk();
           } else {
               playSound(missSoundFilePath);
               System.out.println(getName() + " tarafından iska atış!");
               return false;
           }
       } else {
           playSound(missSoundFilePath);
           System.out.println(getName() + " tarafından iska atış!");
           return false;
       }
   }



    public String getName() {
        return name;
    }
    public static void playSound(String soundFilePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(soundFilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPuan() {
        return point;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public boolean allShipsSunk() {
        return board.allShipsSunk();
    }
}
