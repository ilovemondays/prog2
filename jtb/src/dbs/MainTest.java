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

        Connection conn = LoadDriver.getConnection();


        try {

            ArrayList<Department> deps = printDepartments(conn, false);
            ArrayList<Employee> emps = printRichEmployees(conn, false);
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
    private static ArrayList<Employee> printRichEmployees(Connection conn, boolean print) throws SQLException {

        ArrayList<Employee> emps = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement("SELECT * from hr.employees WHERE salary > ?");
        ps.setLong(1, 7000);
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
                    rs.getFloat(Employee.COMMISSION_PCT),
                    rs.getFloat(Employee.SALARY),
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

}
