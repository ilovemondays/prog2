/**
 * Created by jannis on 15.04.17.
 */
public class MainBallspiele {

    public static void main(String[] args) {

        Ballspiel s= new Ballspiel();
        System.out.println("Ballspiel: ");
        System.out.println("  Mannschaften: " + s.getMannschaften());
        System.out.println("  Spieldauer  : " + s.getSpieldauer());
        System.out.println("  Bälle       : " + s.getBaelle());

        Fussball f= new Fussball();
        System.out.println("Fussball: ");
        System.out.println("  Mannschaften: " + f.getMannschaften());
        System.out.println("  Spieldauer  : " + f.getSpieldauer());
        System.out.println("  Bälle       : " + f.getBaelle());
        System.out.println("  Einwurf     : " + f.einwurfRegel());
        System.out.println("  Ecke        : " + f.eckRegel());

        BeachSoccer bs = new BeachSoccer();
        System.out.println("Fussball: ");
        System.out.println("  Mannschaften: " + bs.getMannschaften());
        System.out.println("  Spieldauer  : " + bs.getSpieldauer());
        System.out.println("  Bälle       : " + bs.getBaelle());
        System.out.println("  Einwurf     : " + bs.einwurfRegel());
        System.out.println("  Ecke        : " + bs.eckRegel());
    }

}
