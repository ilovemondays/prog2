package zusatz01;

import java.awt.Graphics;

/** Klasseninvariante: x&gt;=0 und y&gt;=0. */

public class Loc {
    private int x;
    private int y;

    
    /** Initialisiert das Objekt mit gegebenen Koordinatenwerten.
     *  @param initialX Vorbedingung: &gt;= 0
     *  @param initialY Vorbedigung: &gt;= 0. 
     *  @exception IllegalArgumentException falls einer der Eingabeparameter ung&uuml;ltig ist. 
     */
    public Loc(int initialX, int initialY) {
        setLocation(initialX, initialY);
    }

    public Loc() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, 3, 3);
        //g.drawString("(" + x + ", " + y + ")", x, y);
    }

    /** Setzt die Koordinaten auf neue Werte.
     *  @param newx Vorbedingung: &gt;= 0
     *  @param newy Vorbedigung: &gt;= 0. 
     *  @exception IllegalArgumentException falls einer der Eingabeparameter ung&uuml;ltig ist. 
     */
    public void setLocation(int newx, int newy) {
        if (newx < 0 || newy < 0) {
            throw new IllegalArgumentException("x und y m�ssen >= 0 sein");
        }
        x = newx;
        y = newy;
    }

    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }

    public double distance(Loc other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceFromOrigin() {
        Loc origin = new Loc();
        return distance(origin);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getSector() {
        // winkel = tangens (gegenkathete / ankathete)
        if( getX() == 0 )
            return 8;

        double winkel = Math.asin(getY()/distance(new Loc()));



        return (int) (getGrad(winkel)/10);
    }

    private double getGrad(double radian) {
        //System.out.print(( 360/(2*Math.PI)*radian)+" -> ");
        return 360/(2*Math.PI)*radian;
    }
}
