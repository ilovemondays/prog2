package dbs;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 2d6-znu-u1 on 14.06.17.
 */
public class MainTest {

    public static void main (String[] args) {

        /**
         *
         *
         * @TODO password entfernen....
         *
         *
         *
         */

        aufgabe2(args[0]);

    }

    private static void aufgabe1(String file) {


        Connection conn = LoadDriver.getConnection(file);


        try {

            ArrayList<Department> deps = printDepartments(conn, false);
            ArrayList<Employee> emps = printRichEmployees(conn, 7000, false);
            printDepRichManRelation(conn, emps, deps, true);
            System.out.println("--------------------------------");
            printDepManRelation(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private static void aufgabe2(String file) {


        Connection conn = LoadDriver.getConnection(file);


        try {


            // Aufgabe 2 a) und b)
//            if( tableExists("myChefs", conn) ) {
//                dropTable("myChefs", conn);
//            } else {
//                createTable(conn);
//            }

            // Aufgabe 2 c)
            ArrayList<Employee> richEmployees = printRichEmployees(conn, 8000, false);

            for(Employee e : richEmployees) {
                insertMyChefs(conn, e);
            }

            System.out.print("fin");



        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Aufgabe 11.1 a)
     */
    private static ArrayList<Department> printDepartments(Connection conn, boolean print) throws SQLException {

        ArrayList<Department> deps = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM hr.departments");
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while( rs.next() ) {

            deps.add(new Department(
                    rs.getInt(Department.DEP_ID),
                    rs.getString(Department.DEP_NAME),
                    rs.getInt(Department.MAN_ID),
                    rs.getInt(Department.LOC_ID)
            ));

        }

        rs.close();
        ps.close();

        System.out.println(deps.size()+" departments");

        if( print )
            for(Department d : deps) {
                System.out.println(d.toString());
            }

        return deps;
    }

    /**
     * Aufgabe 11.1 b)
     */
    private static ArrayList<Employee> printRichEmployees(Connection conn, int min, boolean print) throws SQLException {

        ArrayList<Employee> emps = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * from hr.employees WHERE salary > ?");
        ps.setLong(1, min);
        ps.execute();

        ResultSet rs = ps.getResultSet();

        while( rs.next() ) {

            emps.add(new Employee(
                    rs.getInt(Employee.ID),
                    rs.getString(Employee.FIRSTNAME),
                    rs.getString(Employee.LASTNAME),
                    rs.getString(Employee.EMAIL),
                    rs.getString(Employee.PHONE_NUMBER),
                    rs.getDate(Employee.HIRE_DATE),
                    rs.getString(Employee.JOB_ID),
                    rs.getFloat(Employee.SALARY),
                    rs.getFloat(Employee.COMMISSION_PCT),
                    rs.getInt(Employee.MANAGER_ID),
                    rs.getInt(Employee.DEPARTMENT_ID)
            ));

        }

        rs.close();
        ps.close();

        System.out.println(emps.size()+" employees earn more than 7k");

        if( print )
            for(Employee e : emps) {
                System.out.println(e.toString());
            }

        return emps;

    }

    /**
     * Aufgabe 11.1 c)
     */
    private static void printDepRichManRelation(Connection conn, ArrayList<Employee> emps, ArrayList<Department> deps, boolean print) {

        for(Department d : deps) {

            for(Employee e : emps) {

                if( e.getId() == d.getManagerId() ) {
                    System.out.println("Department "+d.getDid()+" has manager "+e.getFirstName()+" "+e.getLastName());
                    break;
                }

            }

        }

    }

    /**
     * Aufgabe 11.1 d)
     */
    private static void printDepManRelation(Connection conn) throws SQLException {

        ArrayList<DepartmentWithManager> depMan = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT d.department_id, department_name, d.location_id, first_name||' '||last_name ManagerName FROM hr.employees e " +
                        "  JOIN hr.departments d ON d.manager_id = e.employee_id"
        );

        ps.execute();

        ResultSet rs = ps.getResultSet();

        while(rs.next()) {
            depMan.add(new DepartmentWithManager(
                    rs.getInt("department_id"),
                    rs.getString("department_name"),
                    rs.getString("ManagerName"),
                    rs.getInt("location_id")
            ));
        }

        for(DepartmentWithManager dm : depMan) {
            System.out.println(dm);
        }

        rs.close();
        ps.close();


    }

    /**
     * Aufgabe 11.2 a)
     *
     * @param name
     * @param conn
     * @throws SQLException
     */
    private static void dropTable(String name, Connection conn) throws SQLException {

        Statement sm = conn.createStatement();
        sm.executeUpdate("DROP TABLE "+name);
        sm.close();
        System.out.println("No errors occurred... did it work? o,o");

    }

    /**
     * Aufgabe 11.2 b)
     *
     * @param conn
     * @throws SQLException
     */
    private static void createTable(Connection conn) throws SQLException {

        PreparedStatement ps = conn.prepareStatement(
                "CREATE TABLE myChefs (employee_id INTEGER, name VARCHAR(50), email VARCHAR(50)" +
                        ", hire_date DATE, salary FLOAT, "+
                        "CONSTRAINT myChefs_pk PRIMARY KEY (employee_id))"
        );

        ps.executeUpdate();
        ps.close();
        System.out.println("No errors on update execution");

    }

    /**
     * Aufgabe 11.2 a)
     *
     * returns true if it exists
     * @param name should be all uppercase (will also be handled inside..its just a friendly reminder)
     * @param conn
     * @return
     * @throws SQLException
     */
    private static boolean tableExists(String name, Connection conn) throws SQLException {
        name = name.toUpperCase();

        PreparedStatement s = conn.prepareStatement(
                "select count(*) from all_objects where object_type in ('TABLE','VIEW') and object_name = ?"
        );
        s.setString(1, name);
        s.execute();

        ResultSet rs = s.getResultSet();
        rs.next();

        int count =  rs.getInt("count(*)");

        s.close();

        return count >= 1;

    }

    private static void insertMyChefs(Connection conn, Employee emp) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO myChefs VALUES"+
                        "(?, ?, ?, ?, ?)"
        );

        // emp id
        ps.setInt(1, emp.getId());

        // name
        ps.setString(2, emp.getFirstName()+" "+emp.getLastName());

        // email
        ps.setString(3, emp.geteMail());

        // hire_date
        ps.setDate(4, java.sql.Date.valueOf(emp.getHireDate().toString()));

        // salary
        ps.setFloat(5, emp.getSalary());

        ps.executeUpdate();

        ps.close();

    }

}
