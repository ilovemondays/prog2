import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Team 13 on 13.05.17.
 */
public class DetectZip {
    /**
     * Main - führt Prüfung auf Zip Datei aus
     * @param args nur ein String Parameter erlaubt. Soll Pfad & Dateiname sein
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if(args.length>0 || args.length==0) {
            //System.out.println("error");
            //return;
        }
        //System.out.println(detect(args[0]));
        System.out.println(detect("matze/NOZIP.txt"));
        System.out.println(detect("matze/ichBinEineZipDatei.zip"));
        System.out.println(detect("matze/ichExistiereNicht.zip"));
    }

    /**
     * Prüft ob angegebene Datei eine Zip-Datei ist
     * @param filename Pfad und Dateiname
     * @return
     * @throws IOException
     */
    public static String detect(String filename) throws IOException {
        FileInputStream input = null;
        boolean isZip = false;

        try {
            input = new FileInputStream(filename);
            // Erstes Byte
            if(input.read() == 80) {
                // Zweites Byte
                if (input.read() == 75) {
                    isZip = true;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(input != null) {
                input.close();
            }
        }

        if(isZip) {
            return "zip";
        }

        return "no zip";
    }
}
