package de.hsh.prog.choreov02;

import de.hsh.prog.choreov02.pub.Direction;

/**
 * Created by jannis on 04.06.17.
 */
public class Direction2 {

    public static Direction stepMove(Direction current) {
        Direction neu = stepMove();
        while(neu==current)
            neu = stepMove();

        return neu;
    }

    public static Direction stepMove() {
        int r = (int)(Math.random() * (5 - 1) + 1);

        switch(r) {
            case 1:
                return Direction.NORTH;
            case 2:
                return Direction.EAST;
            case 3:
                return Direction.SOUTH;
            case 4:
                return Direction.WEST;
            default:
                return Direction.NONE;
        }
    }

    public static Direction stepColor() {
        int r = (int)(Math.random() * (6 - 1) + 1);

        switch(r) {
            case 1:
                return Direction.LESS_BLUE;
            case 2:
                return Direction.LESS_GREEN;
            case 3:
                return Direction.LESS_RED;
            case 4:
                return Direction.MORE_BLUE;
            case 5:
                return Direction.MORE_GREEN;
            case 6:
                return Direction.MORE_RED;
            default:
                return Direction.NONE;
        }
    }

}
