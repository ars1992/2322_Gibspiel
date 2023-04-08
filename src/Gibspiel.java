import java.util.Scanner;


public class Gibspiel {
    public static Spielbrett spielbrett = new Spielbrett();

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
    public static void main(String[] args) {
        spielerAnzahl();

        // Erster Setup für zwei menschliche Spieler
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Name des Spieler 1: ");
        String name = eingabe.next();
        Spieler spieler1 = new MenschSpieler(name);

        Spieler spieler2 = new ComputerSpieler1();

        /*
        System.out.print("Name des Spieler 2: ");
        name = eingabe.next();
        Spieler spieler2 = new MenschSpieler(name);
         */


        spielbrett.startSpiel();
        while (true) {
            if (spielzug(spieler1)) break;
            if (spielzug(spieler2)) break;
        }
    }

    public static boolean spielzug(Spieler spieler1){
        System.out.print("Steine auf dem Brett: ");
        System.out.println(spielbrett.getAktuelleAnzahlSteine());

        int anzahlSteine;
        do {
            anzahlSteine = spieler1.steineSetzen();
        } while ( ! spielbrett.macheZug( anzahlSteine ) );

        if (spielbrett.hatGewonnen()) {
            System.out.println(spieler1.getName() + " hat gewonnen");
            return true;
        }
        return false;
    }

    public static Spieler[] spielerAnzahl(){
        Scanner eingabe = new Scanner(System.in);
        int i;
        do{
            System.out.println("Wählen Sie die Anzahl der Spieler");
            i = eingabe.nextInt();
        }while (i > 2 || i < 0);
        return new Spieler[i];
    }

}
