public class ComputerSpieler1 extends Spieler{


    public ComputerSpieler1(String name) {
        super("Computer Einfach " + name);
    }

    public int steineSetzen() {
        System.out.println("Am Zug: Spieler " + getName());
        if(100 - Gibspiel.spielbrett.getAktuelleAnzahlSteine() < 10)
            return 100 - Gibspiel.spielbrett.getAktuelleAnzahlSteine();
        return (int) (Math.random() * 10 + 1);
    }
}
