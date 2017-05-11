package pseudoanonymPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jannis on 11.05.17.
 */
public class DetectZip {


    /**
     * nanana
     * @param args
     */
    public static void main(String[] args) {

        if( args.length > 1 || args.length == 0 ) {
            System.out.println("error");
            return;
        }

        InputStream is;
        try {

            is = new FileInputStream(args[0]);

            int data[] = new int[2];

            data[0] = is.read();

            if( data[0] == -1 ) {
                // reached end of stream
                System.out.println("no zip");
                return;
            }

            data[1] = is.read();

            if( data[0] == 80 && data[1] == 75 )
                System.out.println("zip");
            else
                System.out.println("no zip");



        } catch (FileNotFoundException e) {
            System.out.println("error");
        } catch (IOException e) {
            System.out.println("error");
        }


    }


}
