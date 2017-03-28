package de.hsh.prog.klasselinev03;
import java.awt.*;
import com.bjp.DrawingPanel;

/**
 * Created by Matthias on 28.03.2017.
 */
public class Line {
    Loc p1, p2;

    /**
     * Legt zwei punkte p1 (x1,y1), p2 (x2,y2) an mit gegebenen koordinaten
     *
     * @param x1 int
     * @param y1 int
     * @param x2 int
     * @param y2 int
     */
    public Line(int x1, int y1, int x2, int y2) {
        p1 = new Loc(x1, y1);
        p2 = new Loc(x2, y2);
    }

    /**
     * Line objeckt initialisiert mit zwei Loc Objekten
     *
     * @param p1
     * @param p2
     */
    public Line(Loc p1, Loc p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getX());
    }

    /**
     * Konstruktor kopiert ein gegebenenes Line Objekt
     * @param line anderes Line Objekt
     * @param deepCopy true für eine Deep-Copy des Line
     */
    public Line(Line line, boolean deepCopy) {
        if(deepCopy) {
            // tiefe kopie
            p1 = new Loc(line.getP1());
            p2 = new Loc(line.getP2());
        } else {
            // flache kopie
            p1 = line.getP1();
            p2 = line.getP2();
        }
    }

    /**
     * Getter p1
     * @return Loc p1
     */
    public Loc getP1() {
        return p1;
    }

    /**
     * Getter p2
     * @return Loc p2
     */
    public Loc getP2() {
        return p2;
    }

    /**
     * Gibt die X,Y Koordinaten von p1 und p2 in dieser Reihenfolge zurück
     * @return String
     */
    public String toString() {
        return String.format("[%s, %s]", p1, p2);
    }

    /**
     * gibt die Länge/ Distanz zwischen p1 und p2 zurück
     * @return double
     */
    public double getLength() {
        return p1.distance(p2);
    }

    /**
     *
     * @param g
     */
    public void draw(Graphics g) {
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    //@TODO: Das hier noch entfernen, dienst zum testen
    public static void main(String[] args) {
        Line ln = new Line(0,0,400,400);
        Line ln2 = new Line(400,0,0,400);
        Loc p1 = new Loc(200,0);
        Loc p2 = new Loc(200,200);
        Line ln3 = new Line(p1, p2);

        DrawingPanel panel = new DrawingPanel(400, 400);
        Graphics g = panel.getGraphics();

        // teste flache-/tiefe-Kopie
        Line ln4 = new Line(ln, true);
        Line ln5 = new Line(ln2, false);

        //ln.draw(g);
        //ln2.draw(g);
        ln3.draw(g);
        ln4.draw(g);
        ln5.draw(g);
    }
}
