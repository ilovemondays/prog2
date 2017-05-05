package de.hsh.prog.klassedashedlinev03;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jannis on 26.04.17.
 */
public class DashedLine extends Line  {

    private int[] dashes;

    public DashedLine(Loc start, Loc end, int[] dashes) {
        super(start, end);
        this.dashes = dashes;
    }

    @Override
    public void draw(Graphics g) {
        int x = getP1().getX();
        int y = getP1().getY();
        double currentLength = 0;
        double totalLength = getP1().distance(getP2());

        int dX = getP2().getX()-getP1().getX();
        int dY = getP2().getY()-getP1().getY();

        int dashIndex = dashes.length; // damit wir auch wirklich im index 0 anfangen

        while( currentLength < totalLength ) {

            dashIndex++;
            if( dashIndex >= dashes.length )
                dashIndex = 0;
            int dashLen = dashes[dashIndex];

            if( dashLen + currentLength > totalLength )
                dashLen = (int) ( totalLength - currentLength );

            double nextX = x + dX * dashLen / totalLength;
            double nextY = y + dY * dashLen / totalLength;

            currentLength += dashLen;

            getP1().setLocation(x, y);
            getP2().setLocation((int) nextX, (int) nextY);

            if( dashIndex % 2 == 0 ) {
                super.draw(g);
            }

            x = (int) nextX;
            y = (int) nextY;

        }

    }

    public String toString() {
        String s = "[[("+getP1().getX()+", "+getP1().getY()+"), ("+getP2().getX()+", "+getP2().getY()+")], dashes=["+dashes[0];

        for(int i=1; i<dashes.length; i++)
            s += ", "+dashes[i];

        return s+"]]";
    }
}
