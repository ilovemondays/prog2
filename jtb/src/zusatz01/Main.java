package zusatz01;

import com.bjp.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Color[] colors= { Color.RED, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.BLACK, Color.YELLOW };
        final int W=400; 
        final int H=300;
        DrawingPanel pnl= new DrawingPanel(W,H);
        Graphics g= pnl.getGraphics();
        final int N= 5000;
        Random rand= new Random();
        for (int i=0; i<N; i++) {
            Loc loc= new Loc(rand.nextInt(W), rand.nextInt(H));
            int index= loc.getSector();
            //System.out.print(index+", ");
            g.setColor(colors[index]);
            loc.draw(g);
        }
    }
}