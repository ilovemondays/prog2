import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Testet Subklassen von <code>Medium</code> und deren Leihfrist.
 */
public class MedienMain {
    public static void main(String[] args) {
        Set<Medium> medien= new HashSet<Medium>();
        Collections.addAll(medien,
                new Buch("Building Java Programs - A Back to Basics Approach",
                        2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
                new CD("Are you Experienced?", 1967, "Jimi Hendrix", 40),
                new Zeitschrift("Der Spiegel", 2010, 3) );
        System.out.println(getMaxErscheinungsjahr(medien));
        // Sortenreines Set von Büchern
        Set<Buch> buecher= new HashSet<Buch>();
        Collections.addAll(buecher,
                new Buch("Building Java Programs - A Back to Basics Approach",
                        2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
                new Buch("Java ist auch eine Insel",
                        2009, "Christian Ullenboom", "Galileo Computing"));
        System.out.println(getMaxErscheinungsjahr(buecher));

        // Sortenreines Set von Zeitschriften
        Set<Zeitschrift> zeitschriften= new HashSet<Zeitschrift>();
        Collections.addAll(zeitschriften,
                new Zeitschrift("Der Spiegel", 2009, 12),
                new Zeitschrift("Der Spiegel", 2010, 1),
                new Zeitschrift("Der Spiegel", 2010, 2));
        System.out.println(getMaxErscheinungsjahr(zeitschriften));
    }
    private static int getMaxErscheinungsjahr(Set<? extends Medium> medien) {
        int maxJahr = -1;
        for (Medium m : medien) {
            if(m.getErscheinungsjahr() > maxJahr) {
                maxJahr = m.getErscheinungsjahr();
            }
        }
        return maxJahr;
    }


}