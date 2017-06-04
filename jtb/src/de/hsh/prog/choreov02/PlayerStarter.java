package de.hsh.prog.choreov02;

import de.hsh.prog.choreov02.pub.Board;
import de.hsh.prog.choreov02.pub.Player;

/**
 * Created by jannis on 04.06.17.
 */
public class PlayerStarter {

    public static void startPlayer(Player player, Board board) {
        circle(player, board);
        System.out.println(board.getWidth()+", "+board.getHeight());
    }

    private static void bounce(Player player, Board board) {
        new Thread(
                new StratBounce(player, board)
        ).start();
    }

    private static void circle(Player p, Board b) {
        new Thread(
                new StratCircle(p, b)
        ).start();
    }
}
