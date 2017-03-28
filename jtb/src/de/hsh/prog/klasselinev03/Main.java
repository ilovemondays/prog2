package de.hsh.prog.klasselinev03;

import com.bjp.DrawingPanel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        DrawingPanel dp = new DrawingPanel(200, 100);
        Graphics g = dp.getGraphics();

        Line line = new Line(20, 3, 199, 10);
        line.draw(g);

        Line line2 = new Line(150, 40, 30, 95);
        line2.draw(g);

    }


}
