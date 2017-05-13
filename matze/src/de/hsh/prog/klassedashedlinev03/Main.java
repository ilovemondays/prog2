package de.hsh.prog.klassedashedlinev03;

import com.bjp.DrawingPanel;
import de.hsh.prog.klasselinev03.Loc;

/**
 * Created by 5m3-9c9-u1 on 05.05.17.
 */
public class Main {
    public static void main(String[] args) {

        DrawingPanel dp = new DrawingPanel(200, 200);
        java.awt.Graphics g = dp.getGraphics();
        int[] dashes= { 15, 25 };
        DashedLine dl1= new DashedLine(new Loc(10, 10), new Loc(190, 10), dashes);
        dl1.draw(g);

        dashes= new int[] { 15, 25, 5, 35 };
        dl1= new DashedLine(new Loc(10, 20), new Loc(190, 20), dashes);
        dl1.draw(g);



        DrawingPanel pnl = new DrawingPanel(400, 300);
        int[] d= new int[] { 15, 10 };
        int cx= pnl.getWidth()/2, cy= pnl.getHeight()/2; // center
        int minDim= Math.min(pnl.getHeight(), pnl.getWidth());
        double r1= minDim/10.0 /*inner radius*/, r2= minDim*4.2/10.0 /*outer radius*/;
        int n= 23; // number of rays
        double incr= Math.PI*2/n; // increment
        for (double arc= 0.2*incr; arc < Math.PI*2; arc += incr) {
            double cos= Math.cos(arc), sin= Math.sin(arc);
            Loc p1= new Loc((int)(cx+r1*cos), (int)(cy+r1*sin));
            Loc p2= new Loc((int)(cx+r2*cos), (int)(cy+r2*sin));
            DashedLine dl= new DashedLine(p1, p2, d);
            dl.draw(pnl.getGraphics());
        }

    }
}
