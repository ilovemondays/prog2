

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by Marius Luding on 13.05.2017 for group 13
 */
@SuppressWarnings("ALL")
public class Decode {

    public static void main(String[] args){
        decode("friends.dat");

    }

    public static void decode(String file){

        try {
            FileInputStream fis = new FileInputStream(file );
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList <Person> deserialized = (ArrayList<Person>) ois.readObject();
            ois.close();

            for (Person per: deserialized) {
                System.out.println(per.getName()+ " mag "+ per.getBestFriend().getName());
            }

        } catch (IOException e) {
            System.out.println("File error");
        } catch (ClassNotFoundException f) {

        }
    }
}
