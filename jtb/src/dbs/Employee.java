package dbs;

import java.util.Date;

/**
 * Created by kleinerc on 18.05.2017.
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
    private Date hireDate;
    private String jobid;
    private float salary;
    private float commissionPct;
    private int managerId;
    private int departmentId;

    public static final String ID = "employee_id";
    public static final String LASTNAME = "last_name";
    public static final String FIRSTNAME = "first_name";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String HIRE_DATE = "hire_date";
    public static final String JOB_ID = "job_id";
    public static final String SALARY = "salary";
    public static final String COMMISSION_PCT = "commission_pct";
    public static final String MANAGER_ID = "manager_id";
    public static final String DEPARTMENT_ID = "department_id";

    public Employee(int id, String firstName, String lastName, String eMail, String phoneNumber, Date hireDate, String jobid, float salary, float commissionPct, int managerId, int departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobid = jobid;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(float commissionPct) {
        this.commissionPct = commissionPct;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobid='" + jobid + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }
}
