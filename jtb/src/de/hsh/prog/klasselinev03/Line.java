package de.hsh.prog.klasselinev03;


import com.bjp.DrawingPanel;

import java.awt.*;

/**
 * Line class
 * Gruppe 13
 */
public class Line {

    private Loc p1, p2;

    /**
     * Initiate a line start point (x1, y1) and end point (x2, y2).
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
     * Instead of 4 coordinate parameters, you can use two Loc parameters.
     * @param l1 Loc
     * @param l2 Loc
     */
    public Line(Loc l1, Loc l2) {
        this(l1.getX(), l1.getY(), l2.getX(), l2.getY());
    }

    /**
     * Create a new Line based on an existing Line.
     * @param copy Line
     * @param deep boolean True to use deep copy method.
     */
    public Line(Line copy, boolean deep) {

        if(deep) {
            p1 = new Loc(copy.getP1());
            p2 = new Loc(copy.getP2());
        } else {
            p1 = copy.getP1();
            p2 = copy.getP2();
        }

    }

    /**
     * Get coordinates for one line ending as Loc.
     * @return Loc
     */
    public Loc getP1() {
        return p1;
    }

    /**
     * Get coordinates for one line ending as Loc.
     * @return Loc
     */
    public Loc getP2() {
        return p2;
    }

    /**
     * Get full length of this line
     * @return double
     */
    public double getLength() {
        return p1.distance(p2);
    }

    /**
     * Draw the line on a panel
     * @param g java.awt.Graphics
     */
    public void draw(Graphics g) {

        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());


    }

    /**
     * Get a list of line coordinates
     * @return String
     */
    public String toString() {
        return "["+p1.toString()+", "+p2.toString()+"]";
    }
}
