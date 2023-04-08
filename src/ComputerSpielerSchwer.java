public class ComputerSpielerSchwer extends Spieler{
    public ComputerSpielerSchwer(String name) {
        super(name);
    }

    @Override
    public int steineSetzen() {
        System.out.println("Am Zug: KI Schwer " + getName());

        int[] j = new int[]{100, 89, 78, 67, 56, 45, 34, 23, 12, 1};
        for (int wert: j){
            for (int i = 1; i <= 10 ; i++) {
                if (Gibspiel.spielbrett.getAktuelleAnzahlSteine() + i == wert)
                    return i;
            }
        }
        return 1;
    }
}
