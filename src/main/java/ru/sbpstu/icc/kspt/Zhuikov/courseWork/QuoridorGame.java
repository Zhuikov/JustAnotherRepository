package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuoridorGame {

    private static final int barriersNumber = 10;
    private static Field field = new Field();
    private short currentPlayer = 0;
    private List<Player> players = new ArrayList<>();
//    private Map<Integer, Player> playerMap = new TreeMap<>();

    public QuoridorGame(int numberOfPlayers) {

        if (numberOfPlayers == 2) {
//            playerMap.put(0, addPlayer(Player.TOP, 0, (field.getRealSize() - 1) / 2));
//            playerMap.put(1, addPlayer(Player.BOTTOM, field.getRealSize() - 1, (field.getRealSize() - 1) / 2));
            players.add(addPlayer(Player.TOP, new Coordinates(0, (field.getRealSize() - 1) / 2)));
            players.add(addPlayer(Player.BOTTOM, new Coordinates(field.getRealSize() - 1, (field.getRealSize() - 1) / 2)));
//            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));                         // players[0] - TOP
//            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2));   // players[1] - BOTTOM
        }

        if (numberOfPlayers != 2) {
            System.out.println("it's not time yet!");       // todo ...
//            players.add(addPlayer(0, (field.getRealSize() - 1) / 2));                       // players[0] - TOP
//            players.add(addPlayer(field.getRealSize() - 1, (field.getRealSize() - 1) / 2)); // players[1] - BOTTOM
//            players.add(addPlayer((field.getRealSize() - 1) / 2, 0));                       // players[2] - LEFT
//            players.add(addPlayer((field.getRealSize() - 1) / 2, field.getRealSize() - 1)); // players[3] - RIGHT
        }


    }

    public boolean moveMarker(Coordinates coordinates) throws ItemFieldException {

        players.get(currentPlayer).moveMarker(coordinates);
        if (++currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return true;
    }

    public boolean placeBarrier(Coordinates coordinates, BarrierPosition position)
            throws NoBarriersException, ItemFieldException {

        players.get(currentPlayer).placeBarrier(coordinates, position);
        if (++currentPlayer == players.size()) {
            currentPlayer = 0;
        }

        return true;
    }

    public Player getCurrentPlayer() {

        switch (currentPlayer) {
            case 0: return Player.TOP;
            case 1: return Player.BOTTOM;
            case 2: return Player.LEFT;
            default: return Player.RIGHT;
        }
    }

    public PlayerInformation getPlayerInformation(Player player) {

        switch (player) {
            case TOP:    return players.get(0).getInformation();
            case BOTTOM: return players.get(1).getInformation();
            case LEFT:   return players.get(2).getInformation();
            default:  return players.get(3).getInformation();
        }
    }

    public boolean isOver() {  //todo кто победил

        return ((players.get(0).getInformation().getCoordinates().getVertical() == 16) ||
                (players.get(1).getInformation().getCoordinates().getVertical() == 0));
    }

    public Field getField() { return field;  }  // todo надо тут нормально сделать

    private Player addPlayer(Player player, Coordinates coordinates) {

        List<Barrier> barriers = new ArrayList<Barrier>();
        for (int i = 0; i < barriersNumber; i++) {
            barriers.add(new Barrier(field));
        }

        return player.createPlayer(new Marker(field, coordinates.getVertical(), coordinates.getHorizontal()), barriers);
    }

}
