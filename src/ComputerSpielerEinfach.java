public class ComputerSpielerEinfach extends Spieler{


    public ComputerSpielerEinfach(String name) {
        super(name);
    }

    public int steineSetzen() {
        System.out.println("Am Zug: KI Einfach " + getName());

        if(100 - Gibspiel.spielbrett.getAktuelleAnzahlSteine() < 10)
            return 100 - Gibspiel.spielbrett.getAktuelleAnzahlSteine();
        return (int) (Math.random() * 10 + 1);
    }
}
