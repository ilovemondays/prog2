package dbs;

/**
 * Created by kleinerc on 18.05.2017.
 */
public class Department {

    private int did;
    private String name;
    private int managerId;
    private int locationId;

    public static final String DEP_ID = "department_id";
    public static final String DEP_NAME = "department_name";
    public static final String MAN_ID = "manager_id";
    public static final String LOC_ID = "location_id";

    public Department(int did, String name, int managerId, int locationId) {
        this.did = did;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                ", locationId=" + locationId +
                '}';
    }


}
