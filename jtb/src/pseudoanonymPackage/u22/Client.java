package pseudoanonymPackage.u22;

/**
 * Created by 2d6-znu-u1 on 29.05.17.
 */
public class Client {
    public void client(RTarget trg) {
        R r= new R();
        trg.put(r);
        STarget st = new STarget();
        st.put(new R());
    }
}
