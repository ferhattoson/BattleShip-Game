public class Battleship {
    private boolean battiMi;
    private int saglam;
    private int boyut;

    public Battleship(int boyut) {
        this.battiMi = false;
        this.saglam = boyut;
        this.boyut = boyut;
    }

    public void decreaseHealth() {
        if (saglam > 0) {
            saglam--;
            if (saglam == 0) {
                battiMi = true;
            }
        }
    }

    public boolean isSunk() {
        return battiMi;
    }

    public int getSize() {
        return boyut;
    }
}

