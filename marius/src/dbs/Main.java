package dbs;

import java.sql.*;
import java.util.ArrayList;



/**
 * Created by krz-nqy-u1 on 15.06.17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Department> dlist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@dboracleserv.inform.hs-hannover.de:1521:db01",
                    "krz-nqy-u1", args[0]);

            String query = "SELECT * FROM hr.departments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int dpid = rs.getInt("department_id");
                String dpname = rs.getString("department_name");
                int manid = rs.getInt("manager_id");
                int locid = rs.getInt("location_id");


                Department d = new Department(dpid,dpname,manid,locid);
                dlist.add(d);


            }

            //dlist.forEach(System.out::println);



            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ArrayList<Employee> elist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@dboracleserv.inform.hs-hannover.de:1521:db01",
                    "krz-nqy-u1", args[0]);

            String query = "SELECT * FROM hr.employees WHERE Salary>=7000";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Employee> list = new ArrayList<>();
            while (rs.next()) {
                int eId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                String email = rs.getString(4);
                String pNum = rs.getString(5);
                Date hDate = rs.getDate(6);

                String jobID = rs.getString(7);
                float salary = rs.getFloat(8);
                //if(rs.wasNull()) salary=0;
                float commission = rs.getFloat(9);
                //if(rs.wasNull()) commission=0;
                int mId = rs.getInt(10);
                int depId = rs.getInt(11);




                Employee e = new Employee(eId,firstName,lastName,email,pNum,hDate,jobID,salary,commission,mId,depId);

                elist.add(e);


            }

            //elist.forEach(System.out::println);



            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        for(Department d:dlist){
            System.out.print(d);
            if ( for(Employee e: elist) {

            }
            )
        }

    }
}
