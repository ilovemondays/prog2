package de.hsh.prog.klassedashedlinev03;

import java.awt.*;


/**
 * Created by Marius Luding on 02.05.2017 for group 13
 */
public class DashedLine extends Line {

    private int[] dashes;

    public DashedLine(Loc start, Loc end, int[] dashes) {
        super(start, end);
        this.dashes = dashes;
    }

    @Override public void draw(Graphics g) {
        int startX = getP1().getX();
        int startY = getP1().getY();

        int distX = getP2().getX()-getP1().getX();
        int distY = getP2().getY()-getP1().getY();

        double  totalLength = getLength();
        double currentLength = 0;
        int dashLengthIndex = 0;
        while( currentLength < totalLength) {
            dashLengthIndex++;
            if (dashLengthIndex>= dashes.length) {
                dashLengthIndex= 0;
            }
            int dashLength = dashes[dashLengthIndex];
            if(dashLength + currentLength > totalLength) {
                dashLength = (int) (totalLength - currentLength);
            }

            double nextX = startX+distX * dashLength /totalLength;
            double nextY = startY+distY * dashLength /totalLength;

            currentLength += dashLength;

            if( dashLengthIndex % 2 == 0) {
                getP1().setLocation(startX, startY);
                getP2().setLocation((int)nextX,(int)nextY);
                super.draw(g);
            }

            startX = (int) nextX;
            startY = (int) nextY;

        }
    }

    @Override public String toString() {
        String s = "[[("+getP1().getX()+", "+getP1().getY()+"), ("+getP2().getX()+", "+getP2().getY()+")], dashes=["+dashes[0];

        for(int i=1; i<dashes.length; i++)
            s += ", "+dashes[i];

        return s+"]]";
    }
}

