import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by matze on 21.05.17.
 */
public class Decode {
    public static void decode(String filename) throws IOException {
        ArrayList<Person> persons = new ArrayList<Person>();
        FileInputStream fs = null;
        ObjectInputStream os = null;
        // Person person = null;

        try {
            fs = new FileInputStream(filename);
            os = new ObjectInputStream(fs);

            persons = (ArrayList<Person>) os.readObject();

            /*
            while((person = (Person)os.readObject()) != null) {
                System.out.println(person);
                System.out.println(123);
                persons.add(person);
            }
            */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(fs != null) {
                fs.close();
            }
            if(os != null) {
                os.close();
            }
        }

        // System.out.println(persons.toString());
        for (Person p: persons) {
            System.out.println(p.getName() +" mag "+ p.getBestFriend().getName());
        }
    }
}
