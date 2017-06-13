package de.hsh.prog.choreov02;

import de.hsh.prog.choreov02.pub.Board;
import de.hsh.prog.choreov02.pub.Direction;
import de.hsh.prog.choreov02.pub.Player;

import java.awt.*;
import java.util.Random;

/**
 * Created by Marius Luding on 02.06.2017 for group 13
 */
public class spielStrategie implements Runnable {
    private Player player;
    private Board board;
    private int StartGoldArea = 0;
    private int StartRedArea = 0;
    public spielStrategie(Player player, Board board) {
        this.player = player;
        this.board = board;
        if (board.getHeight() > 0) {
            StartGoldArea = (board.getHeight() * 2 / 3);
            StartRedArea = (board.getHeight() * 1 / 3);
        }
    }

    @Override
    public void run() {

        //System.out.println(player.getNumber());
        //System.out.println(player.getStartPosition());
        Random r = new Random();
        int color = r.nextInt(3);
        //System.out.println(color);
        switch(color) {
            case 0: setColorBlack();
                    break;
            case 1: setColorRed();
                    break;
            case 2: setColorGold();
                    break;
        }





        bounce(Direction.EAST);

    }

    private void bounce(Direction direction) {
        Direction reverse = getOppositeDirection(direction);


        while (true) {
            moveLoop(direction);
            moveLoop(reverse);
        }
    }

    private void moveLoop(Direction direction) {
        while (board.canMove(this.player, direction)) {

            board.move(this.player, direction);

        }
    }
    private void move(Direction direction) {
        if (board.canMove(this.player, direction)) {

            board.move(this.player, direction);

        }
    }
    private void goToSector(int start) {
        Point player = board.getCurrentPosition(this.player);
        int y = (int) player.getY();
        //System.out.println(start + " col");
        //System.out.println(y + " pos");
        int Distanz;
        Distanz = (y - start)/10;


        //System.out.println(Distanz);
        move(Direction.NORTH,Distanz);



    }
    private void move(Direction direction, int distanz){
        if (distanz<0) {
            direction=getOppositeDirection(direction);
        }
        for (int d=0;d<Math.abs(distanz);d++) {
            if (board.canMove(this.player, direction)) {

                board.move(this.player, direction);

            }
        }
    }

    private void setColorBlack() {
        maxDirection(Direction.LESS_RED);
        maxDirection(Direction.LESS_BLUE);
        maxDirection(Direction.LESS_GREEN);
        goToSector(0);
        scrambleInArea();
    }
    private void setColorRed() {
        maxDirection(Direction.LESS_GREEN);
        maxDirection(Direction.LESS_BLUE);
        maxDirection(Direction.MORE_RED);
        goToSector(StartRedArea);
        scrambleInArea();
    }

    private void setColorGold() {
        maxDirection(Direction.MORE_GREEN);
        move(Direction.LESS_GREEN);
        maxDirection(Direction.LESS_BLUE);
        maxDirection(Direction.MORE_RED);
        goToSector(StartGoldArea);
        scrambleInArea();

    }
    private void scrambleInArea() {
        Random r2 = new Random();
        int offset = r2.nextInt(board.getHeight()/30);
        move(Direction.SOUTH,offset);
    }

    public void maxDirection(Direction direction) {
        moveLoop(direction);
    }

    public Direction getOppositeDirection(Direction original) {
        Direction opposite = original;
        switch (opposite) {
            case EAST:  opposite=Direction.WEST;
                break;
            case WEST:  opposite=Direction.EAST;
                break;
            case SOUTH:  opposite=Direction.NORTH;
                break;
            case NORTH:  opposite=Direction.SOUTH;
                break;
        }
        return opposite;
    }



}
