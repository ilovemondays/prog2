package de.hsh.prog.choreov02;
import de.hsh.prog.choreov02.pub.Board;
import de.hsh.prog.choreov02.pub.Player;

import java.awt.Point;
public class PlayerStarter{

    public static void startPlayer(Player player, Board board) {
        Thread t = new Thread(new spielStrategie(player,board));
        t.start();
    }


}