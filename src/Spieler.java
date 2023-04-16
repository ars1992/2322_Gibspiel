public abstract class Spieler {
    private String name;

    public Spieler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int steineSetzen(int aktuelleAnzahlSteine);
}
