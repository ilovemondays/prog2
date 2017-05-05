package de.hsh.prog.klassedashedlinev03;

import java.awt.*;

/**
 * Created by team13 on 05.05.17.
 */
public class DashedLine extends Line {
    private int[] dashes;

    public DashedLine(Loc p1, Loc p2, int[] dashes) {
        super(p1, p2);
        this.dashes = dashes;
    }

    public void draw(Graphics g) {
        int x;
        int y;
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
                getP1().setLocation(x, y);
                getP2().setLocation((int)nextx, (int)nexty);
                super.draw(g);
            }

            x = (int)nextx;
            y = (int)nexty;
            counter++;
        }
    }
}
