package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

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

    public List<Message> makeMove(Command command) {

        List<Message> messages = new LinkedList<>();

        switch (command.getCommandType()) {
            case MARKER:
                try {
                    players.peek().moveMarker(command.getVertical(), command.getHorizontal());
                    players.add(players.poll());
                } catch (ItemFieldException | ArrayIndexOutOfBoundsException e) {
                    messages.add(new Message(e.getMessage()));
                }
                break;

            case BARRIER:
                try {
                    players.peek().putBarrier(command.getVertical(), command.getHorizontal(), command.getBarrierPosition());
                    players.add(players.poll());
                } catch (ItemFieldException | NoBarriersException | ArrayIndexOutOfBoundsException e) {
                    messages.add(new Message(e.getMessage()));
                }
                break;

        }

        return messages;

    }

    private Player addPlayer(int markerVertical, int markerHorizontal) {

        List<Barrier> barriers = new ArrayList<Barrier>();
        for (int i = 0; i < barriersNumber; i++) {
            barriers.add(new Barrier(field));
        }
        return new Player(new Marker(field, markerVertical, markerHorizontal), barriers);

    }

}
