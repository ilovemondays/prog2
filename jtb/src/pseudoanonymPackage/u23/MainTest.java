package pseudoanonymPackage.u23;

/**
 * Testet Subklassen von <code>Medium</code> und deren Leihfrist.
 */
public class MainTest {
    /** Hauptroutine */
    public static void main(String[] args) {
        Medium[] medien= {
                new Buch("Building Java Programs - A Back to Basics Approach",
                        2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
                new CD("Are you Experienced?", 1967, "Jimi Hendrix", 40),
                new Zeitschrift("Der Spiegel", 2010, 3)
        };


        for (Medium m : medien) {
            System.out.println(m);
            System.out.println("  Leihfrist: " + m.getLeihFrist());
        }

        CD asd = new CD("Achtung Baby", 1995, "U2", 55);
        asd.setErscheinungsjahr(0);


    }
}