package dbs;

/**
 * Created by kleinerc on 18.05.2017.
 */
public class DepartmentWithManager {

    private int did;
    private String name;
    private String manager;
    private int locationId;

    public DepartmentWithManager(int did, String name, String manager, int locationId) {
        this.did = did;
        this.name = name;
        this.manager = manager;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager  = manager;
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
                ", manager=" + manager +
                ", locationId=" + locationId +
                '}';
    }


}
