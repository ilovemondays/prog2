package u17;

import java.io.*;

/**
 * Created by Marius Luding on 13.05.2017 for group 13
 */
public class DetectZip {
    /**
     * Uses a given, valid filename and looks for a file of that name in the working directory
     * if found it checks weather the file is a valid *.zip file, or not and then outputs it findings to the console
     * @param args one command line
     */
    public static void main (String[] args){
        String filename = null;

        if (args.length != 1) {
            error();
        } else {
        filename = args[0];
        }
        if (!filename.endsWith(".zip") ) error();

        try {
            InputStream in = new FileInputStream(filename);
            int firstblock = in.read();
            int secondblock = in.read();
            in.close();

            if (firstblock==80||secondblock==75){
                System.out.println("zip");
            } else {
                System.out.println("no zip");
            }


        } catch (IOException f) {
            error();
        }








    }

    /**
     * Outputs the string "error" on the command line
     */
    private static void error() {
        System.out.println("error");
    }
}
