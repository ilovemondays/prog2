package de.hsh.prog.klassedashedlinev03;

import de.hsh.prog.klasselinev03.Line;
import de.hsh.prog.klasselinev03.Loc;

import java.awt.*;

/**
 * Created by team13 on 05.05.17.
 */
public class DashedLine extends Line {
    private int[] dashes;

    /**
     * Constructor
     * @param p1
     * @param p2
     * @param dashes
     */

    public DashedLine(Loc p1, Loc p2, int[] dashes) {
        super(p1, p2);
        this.dashes = dashes;
    }

    /**
     * Draws a dashed line onto the given graphicspanel
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        double x;
        double y;
        int counter = 0;
        double currentLen = 0;
        double totalLen = getP1().distance(getP2());
        double dashLen;

        int dX = getP2().getX() - getP1().getX();
        int dY = getP2().getY() - getP1().getY();

        x = getP1().getX();
        y = getP1().getY();

        double nextx, nexty;

        while(currentLen < totalLen) {

            dashLen = dashes[counter % dashes.length];

            if(dashLen + currentLen > totalLen) {
                dashLen = totalLen - currentLen;
            }
            System.out.println(dashLen);
            nextx = x + dX * dashLen / totalLen;
            nexty = y + dY * dashLen / totalLen;
            currentLen += dashLen;

            // start with first array element == 0
            if(counter % 2 == 0) {
                getP1().setLocation((int)x, (int) y);
                getP2().setLocation((int)nextx, (int)nexty);
                super.draw(g);
            }

            x = nextx;
            y = nexty;
            counter++;
        }
    }

    /**
     * Standard toString utility method
     * @return
     */
    @Override public String toString() {
        String s = "["+super.toString()+", dashes=["+dashes[0];

        for(int i=1; i<dashes.length; i++)
            s += ", "+dashes[i];

        return s+"]]";
    }
}
