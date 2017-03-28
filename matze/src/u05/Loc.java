package u05;
import java.awt.Graphics;

/** Klasseninvariante: x&gt;=0 und y&gt;=0. */

public class Loc {
    private int x;
    private int y;

    /** Initialisiert das Objekt mit gegebenen Koordinatenwerten.
     *  @param initialX Vorbedingung: >= 0
     *  @param initialY Vorbedigung: >= 0.
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
        g.drawString("(" + x + ", " + y + ")", x, y);
    }

    /** Setzt die Koordinaten auf neue Werte.
     *  @param newx Vorbedingung: >= 0
     *  @param newy Vorbedigung: >= 0.
     *  @exception IllegalArgumentException falls einer der Eingabeparameter ung&uuml;ltig ist.
     */
    public void setLocation(int newx, int newy) {
        if (newx < 0 || newy < 0) {
            throw new IllegalArgumentException("x und y müssen >= 0 sein");
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

    /**
     * returns the manhattenDistance between this and an other given Loc object
     *
     * @param loc from type Loc
     * @return int
     */
    public int manhattanDistance(Loc loc) {
        int dx = this.x - loc.getX();
        int dy = this.x - loc.getY();

        return Math.abs(dx+dy);
    }
}