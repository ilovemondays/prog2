package dbs;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by 2d6-znu-u1 on 14.06.17.
 */
public class LoadDriver{

    public static Connection getConnection(String fileSource) {


        try {
            Scanner s = new Scanner(new File(fileSource));
            String db = s.nextLine();
            String user = s.nextLine();
            String pw = s.nextLine();
            s.close();
            // asdasd push den krams


            return DriverManager.getConnection(db, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
