package pseudoanonymPackage;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by jannis on 11.05.17.
 */
public class Decode {

    /**
     * yadda yadda
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));

        try {
            decode("jtb/src/friends.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * Decode a given file and print values
     * @param filePath String
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void decode(String filePath) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream( filePath );
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Person> p = (ArrayList<Person>) ois.readObject();
        ois.close();

        for(Person per : p) {
            System.out.println(per.getName() + " mag " + per.getBestFriend().getName());
        }

    }


}
