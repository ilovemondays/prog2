import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Team 13 on 13.05.17.
 */
public class DetectZip {
    public static void main(String[] args) throws IOException {
        if(args.length>0 || args.length==0) {
            //System.out.println("error");
            //return;
        }
        //System.out.println(detect(args[0]));
        System.out.println(detect("matze/NOZIP.txt"));
        System.out.println(detect("matze/ichBinEineZipDatei.zip"));
    }

    public static String detect(String filename) throws IOException {
        FileInputStream input = null;
        int counter = 1;
        boolean isZip = false;

        try {
            input = new FileInputStream(filename);
            while(input.available() != 0) {
                if(counter==1) {
                    // erste Zahl
                    if (input.read() != 80) {
                        break;
                    }
                }
                if(counter==2) {
                    // zweite Zahl
                    if (input.read() == 75) {
                        isZip = true;
                        break;
                    }
                }
                if(counter==3) {
                    break;
                }
                counter++;
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
