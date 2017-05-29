package u24.anonymeKlasse;

/**
 * Created by jannis on 24.05.17. changed to using anonymous class 'glocke' by Marius 28.05.17
 */
public class TuerglockeMain {
    public static void main(String[] args) {
        Klingelknopf knopf= new Klingelknopf();

        // die geforderte umsetzung mit einer anonymen klasse
        knopf.setBeobachter(new Beobachter() {
            @Override
            public void update(BeobachtetesObjekt o) {
                if( o.getZustand().equals("gedrueckt") )
                    System.out.println("Klingeling");
                else if( o.getZustand().equals("losgelassen") )
                    System.out.println("Stille");
            }
        });



        //oder mit 'lambda' Verkürzung "If the anonymous class has more methods the substitution is not possible."

        knopf.setBeobachter(o -> {
                if( o.getZustand().equals("gedrueckt") )
                    System.out.println("Klingeling");
                else if( o.getZustand().equals("losgelassen") )
                    System.out.println("Stille");
            }
        );




        knopf.knopfDruecken();
        knopf.knopfLoslassen();
        knopf.knopfDruecken();
        knopf.knopfLoslassen();



    }
}
