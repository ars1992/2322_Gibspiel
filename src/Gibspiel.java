import java.util.Scanner;


public class Gibspiel {

    /*
     * Ein Spiel für 2 Spieler.
     * Jeder Spieler kann 1-10 Elemente auf einem Spielbrett plazieren,
     * selbst gewählt, mindestens eins, maximal 10 Elemente.
     * Welcher Spieler das 100. Element hinlegt, hat gewonnen.
     * Das Spiel beginnt mit einer zufälligen Anzahl von Elementen (< 30),
     * die bereits auf dem Spielbrett liegen.
     *
     * Benutzen Sie das Konzept der Vererbung, um wahlweise einen
     * menschlichen oder computergesteuerten Spieler teilnehmen zu lassen
     * (0, 1 oder 2 Computerspieler).
     *
     * Verwenden Sie am Anfang eine schwache KI für den computergesteuerten
     * Spieler.
     *
     * Notwendige Klassen:
     * - Spieler
     *   - MenschSpieler
     *   - ComputerSpieler
     * - Spielbrett
     */
    public static int spielerAnzahl = 3;
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Spielbrett spielbrett = new Spielbrett();

        Spieler[] spieler = gegenspielerBestimmen(eingabe);

        spielbrett.startSpiel();
        loop:
        while (true) {
            for (int i = 0; i < spieler.length; i++)
                if (spielzug(spieler[i], spielbrett)) break loop;

        }
    }

    public static boolean spielzug(Spieler spieler, Spielbrett spielbrett){
        System.out.print("Steine auf dem Brett: ");
        System.out.println(spielbrett.getAktuelleAnzahlSteine());

        int anzahlSteine;
        do {
            anzahlSteine = spieler.steineSetzen(spielbrett.getAktuelleAnzahlSteine());
        } while ( ! spielbrett.macheZug( anzahlSteine ) );

        if (spielbrett.hatGewonnen()) {
            System.out.println(spieler.getName() + " hat gewonnen");
            return true;
        }
        return false;
    }

    public static Spieler[] setzeSpielerAnzahl(Scanner eingabe){
        int i;
        do{
            System.out.println("Wählen Sie die Anzahl der Spieler (1-" + spielerAnzahl + ") : ");
            i = eingabe.nextInt();
        }while (i > spielerAnzahl || i <= 0);
        return new Spieler[i];
    }


    public static String namensgebung(int i, Scanner eingabe){
        System.out.println("Name des Spielers" + (i +1));
        return eingabe.nextLine();
    }

    public static Spieler[] gegenspielerBestimmen(Scanner eingabe){
        Spieler[] listeDerSpieler = setzeSpielerAnzahl(eingabe);
        for (int i = 0; i < listeDerSpieler.length; i++) {
            System.out.println("Wählen Sie Spieler" + (i + 1));
            System.out.println("1 - KI Einfach");
            System.out.println("2 - Ki Mittel");
            System.out.println("3 - KI Schwer");
            System.out.println("4 - Mensch");
            int a = eingabe.nextInt();
            switch (a){
                case 1 -> listeDerSpieler[i] = new ComputerSpielerEinfach(namensgebung(i, new Scanner(System.in)));
                //case 1 -> listeDerSpieler[i] = new ComputerSpielerEinfach(namensgebung(i, eingabe));
                case 2 -> listeDerSpieler[i] = new ComputerSpielerMittel(namensgebung(i, new Scanner(System.in)));
                case 3 -> listeDerSpieler[i] = new ComputerSpielerSchwer(namensgebung(i, new Scanner(System.in)));
                case 4 -> listeDerSpieler[i] = new MenschSpieler(namensgebung(i, new Scanner(System.in)));
                default -> i--;
            }
        }
        return listeDerSpieler;
    }
}
