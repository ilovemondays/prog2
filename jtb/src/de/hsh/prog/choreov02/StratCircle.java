package de.hsh.prog.choreov02;

import de.hsh.prog.choreov02.pub.Board;
import de.hsh.prog.choreov02.pub.Direction;
import de.hsh.prog.choreov02.pub.Player;

import java.awt.*;

/**
 * Created by jannis on 04.06.17.
 */
public class StratCircle implements Runnable {

    private Player p;
    private Board b;

    private static double degree = 1*Math.PI;
    private static double radius = 20;
    private static Point center = new Point();

    private Point destA = new Point();
    private Point destB = new Point();
    private boolean towardsDestinyB = true;


    public StratCircle(Player p, Board b) {
        this.p = p;
        this.b = b;
        if( center.getX() == 0 ) {
            center.setLocation( b.getWidth()/2, b.getHeight()/2 );
        }

        setFixPoints();
        p.setStartPosition(destA);
        p.setStartColor(Color.GREEN);
        System.out.println("DestA: "+destA);
        System.out.println("DestB: "+destB);
        degree /= 2;
    }

    @Override
    public void run() {

        while( true ) {

            if( towardsDestinyB ) {

                Point dist = indirectDistance(b.getCurrentPosition(p), destB );
                if( dist.getY() > dist.getX() )
                    b.move(p, Direction.EAST);
                else
                    b.move(p, Direction.NORTH);

            } else {

                Point dist = indirectDistance(b.getCurrentPosition(p), destA );
                if( dist.getY() > dist.getX() )
                    b.move(p, Direction.WEST);
                else
                    b.move(p, Direction.SOUTH);


            }

            if( towardsDestinyB && isInRange(destB) )
                towardsDestinyB = false;
            else if( !towardsDestinyB && isInRange(destA) )
                towardsDestinyB = true;

        }


    }

    private void setFixPoints() {
        // x = A = H * cos(degree)
        // y = A = H * sin(degree)
        destA.setLocation(
                (int) ( radius * Math.cos(degree) ) + center.getX() ,
                (int) ( radius * Math.sin(degree) ) + center.getY()
        );

        destB.setLocation(
                (int) ( radius * Math.cos(degree+Math.PI) + center.getX() ),
                (int) ( radius * Math.sin(degree+Math.PI) + center.getY() )
        );

    }

    private boolean isInRange(Point dest) {

        Point current = b.getCurrentPosition(p);
        int checkRange = 11;

        return current.getX() <= dest.getX()+checkRange && current.getX() >= dest.getX()-checkRange &&
                current.getY() <= dest.getY()+checkRange && current.getY() >= dest.getY()-checkRange;
    }

    private Point indirectDistance(Point from, Point to) {
        return new Point( (int) Math.abs(from.getX()-to.getX()), (int) Math.abs(from.getY()-to.getY()) );
    }
}
