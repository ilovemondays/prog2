package de.hsh.prog.klassedashedlinev03;

import com.bjp.DrawingPanel;

import java.awt.*;

/**
 * Created by jannis on 26.04.17.
 */
public class Test {

    public static void main(String[] args) {

        DrawingPanel dp = new DrawingPanel(200, 100);
        Graphics g = dp.getGraphics();

        int[] dashes= { 15, 25 };
        DashedLine dl= new DashedLine(new Loc(10, 10), new Loc(190, 10), dashes);
        dl.draw(g);

        dashes= new int[] { 15, 25, 5, 35 };
        dl= new DashedLine(new Loc(10, 20), new Loc(190, 20), dashes);
        dl.draw(g);

    }
}
