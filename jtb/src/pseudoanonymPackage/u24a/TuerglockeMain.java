package pseudoanonymPackage.u24a;

/**
 * Created by jannis on 24.05.17.
 */
public class TuerglockeMain {
    public static void main(String[] args) {
        Klingelknopf knopf= new Klingelknopf();



        class Tuerglocke implements Beobachter {

            @Override
            public void update(BeobachtetesObjekt o) {
                if( o.getZustand().equals("gedrueckt") )
                    System.out.println("Klingeling");
                else if( o.getZustand().equals("losgelassen") )
                    System.out.println("Stille");
            }
        }

        knopf.setBeobachter(new Tuerglocke());




        knopf.knopfDruecken();
        knopf.knopfLoslassen();
        knopf.knopfDruecken();
        knopf.knopfLoslassen();



    }
}
