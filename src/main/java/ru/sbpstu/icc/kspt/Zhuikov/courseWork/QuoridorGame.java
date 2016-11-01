package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.PlayerPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.ArrayList;
import java.util.List;

public class QuoridorGame {

    private static final int barriersNumber = 10;
    private static Field field = new Field();
    private short currentPlayer = 0;                    // todo эту штуку сделать playerPosition
    private List<Player> players = new ArrayList<>();

    public QuoridorGame(int numberOfPlayers) {

        if (numberOfPlayers == 2) {
            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));                         // players[0] - TOP
            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2));   // players[1] - BOTTOM
        }

        if (numberOfPlayers != 2) {
            System.out.println("it's not time yet!");       // todo ...
//            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));                       // players[0] - TOP
//            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2)); // players[1] - BOTTOM
//            players.add(addPlayer((field.getRealSize() - 1) / 2, 0));                       // players[2] - LEFT
//            players.add(addPlayer((field.getRealSize() - 1) / 2, field.getRealSize() - 1)); // players[3] - RIGHT
        }

    }

    public boolean moveMarker(int vertical, int horizontal) throws ItemFieldException {

        players.get(currentPlayer).moveMarker(vertical, horizontal);
        if (++currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return true;
    }

    public boolean placeBarrier(int vertical, int horizontal, BarrierPosition position)
            throws NoBarriersException, ItemFieldException {

        players.get(currentPlayer).placeBarrier(vertical, horizontal, position);
        if (++currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return true;
    }

    public PlayerPosition getCurrentPlayer() {

        switch (currentPlayer) {
            case 0: return PlayerPosition.TOP;
            case 1: return PlayerPosition.BOTTOM;
            case 2: return PlayerPosition.LEFT;         // todo а если их нет, то будет nullptr
            case 3: return PlayerPosition.RIGHT;
        }

        throw new AssertionError("counter currentPlayer broke");
    }

    public PlayerInformation getPlayerInformation(PlayerPosition playerPosition) {

        switch (playerPosition) {
            case TOP:    return players.get(0).getInformation();
            case BOTTOM: return players.get(1).getInformation();
            case LEFT:   return players.get(2).getInformation();
            case RIGHT:  return players.get(3).getInformation();
        }

        throw new AssertionError("argument playerPosition broke");
    }

    public Field getField() { return field;  }  // todo надо тут нормально сделать

    private Player addPlayer(int markerVertical, int markerHorizontal) {

        List<Barrier> barriers = new ArrayList<Barrier>();
        for (int i = 0; i < barriersNumber; i++) {
            barriers.add(new Barrier(field));
        }

        return new Player(new Marker(field, markerVertical, markerHorizontal), barriers);
    }

}
