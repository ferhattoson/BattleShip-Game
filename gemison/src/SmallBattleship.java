public class SmallBattleship extends Battleship {
    // Bu sınıfın tahtada bulunabilecek toplam gemi sayısını belirten statik bir özellik
    public static final int TOTAL_SHIPS = 3;

    public SmallBattleship() {
        // Boyutu 1 olarak belirliyoruz
        super(1);
    }
}
