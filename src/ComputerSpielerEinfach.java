public class ComputerSpielerEinfach extends Spieler{


    public ComputerSpielerEinfach(String name) {
        super(name);
    }

    public int steineSetzen(int akteuelleAnzahlSteine) {
        System.out.println("Am Zug: KI Einfach " + getName());

        if(100 - akteuelleAnzahlSteine < 10)
            return 100 - akteuelleAnzahlSteine;
        return (int) (Math.random() * 10 + 1);
    }
}
