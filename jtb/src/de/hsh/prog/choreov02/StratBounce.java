package de.hsh.prog.choreov02;

import de.hsh.prog.choreov02.pub.Board;
import de.hsh.prog.choreov02.pub.Direction;
import de.hsh.prog.choreov02.pub.Player;

/**
 * Created by jannis on 04.06.17.
 */
public class StratBounce implements Runnable {

    Direction dirHor;
    Direction dirVer;
    Board b;
    Player p;

    public StratBounce(Player player, Board board) {
        b = board;
        p = player;

        dirHor = Direction.EAST;
        dirVer = Direction.NORTH;
    }

    @Override
    public void run() {

        int step = 0;
        Direction col = Direction2.stepColor();

        while(true) {

            if( step % 2 == 0 ) {

                if( b.canMove(p, dirHor) ) {
                    b.move(p, dirHor);
                } else {
                    dirHor = dirHor == Direction.EAST ? Direction.WEST : Direction.EAST;
                }

            } else {


                if( b.canMove(p, dirVer) ) {
                    b.move(p, dirVer);
                } else {
                    dirVer = dirVer == Direction.NORTH ? Direction.SOUTH : Direction.NORTH;
                }

            }

            step++;


            if( b.canMove(p, col) )
                b.move(p, col);
            else
                col = Direction2.stepColor();


        }

    }

}
