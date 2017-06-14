package dbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 2d6-znu-u1 on 14.06.17.
 */
public class LoadDriver{

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(
                    "jdbc:oracle:thin:@dboracleserv.inform.hs-hannover.de:1521:db01",
                    "", ""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
