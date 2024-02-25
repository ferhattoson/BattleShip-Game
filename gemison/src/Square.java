
public class Square {
    private int row=10;
    private int column=10;
    private boolean gemiVarMi;
    private Battleship gemi;
    private boolean atisYapildiMi;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
        this.gemiVarMi = false;
        this.atisYapildiMi = false;
    }

    public int getSatir() {
        return row;
    }

    public int getSutun() {
        return column;
    }

    public boolean isGemiVarMi() {
        return gemiVarMi;
    }

    public void setGemiVarMi(boolean gemiVarMi) {
        this.gemiVarMi = gemiVarMi;
    }

    public Battleship getGemi() {
        return gemi;
    }

    public void setGemi(Battleship gemi) {
        this.gemi = gemi;
    }

    public boolean isAtisYapildiMi() {
        return atisYapildiMi;
    }

    public void setAtisYapildiMi(boolean atisYapildiMi) {
        this.atisYapildiMi = atisYapildiMi;
    }

    public boolean containsShip() {
        return gemiVarMi;
    }
    public boolean isHit() {
        return atisYapildiMi;
    }
    @Override
    public String toString() {
        if (atisYapildiMi) {
            if (gemiVarMi) {
                return "x";
            } else {
                return "o";
            }
        } else {
            return "-";
        }
    }
}
