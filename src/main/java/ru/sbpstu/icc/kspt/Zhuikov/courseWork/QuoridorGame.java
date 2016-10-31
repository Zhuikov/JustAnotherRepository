package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QuoridorGame {

    private static final int barriersNumber = 10;
    private static Field field = new Field();
    private Queue<Player> players = new LinkedList<Player>();

    public QuoridorGame(int numberOfPlayers) {

        if (numberOfPlayers == 2) {
            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));
            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2));
        }

        if (numberOfPlayers == 4) {
            System.out.println("it's not time yet!");
//            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));
//            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2));
//            players.add(addPlayer((field.getRealSize() - 1) / 2, 0));
//            players.add(addPlayer((field.getRealSize() - 1) / 2, field.getRealSize() - 1));
        }

    }

    public void moveMarker(int vertical, int horizontal) throws ItemFieldException {

        players.peek().moveMarker(vertical, horizontal);
        players.add(players.poll());
    }

    public void placeBarrier(int vertical, int horizontal, BarrierPosition position)
            throws NoBarriersException, ItemFieldException {

        players.peek().placeBarrier(vertical, horizontal, position);
        players.add(players.poll());
    }

    private Player addPlayer(int markerVertical, int markerHorizontal) {

        List<Barrier> barriers = new ArrayList<Barrier>();
        for (int i = 0; i < barriersNumber; i++) {
            barriers.add(new Barrier(field));
        }

        return new Player(new Marker(field, markerVertical, markerHorizontal), barriers);
    }

}
