package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.List;

public enum Player {

    TOP,
    BOTTOM,
    RIGHT,
    LEFT;

    private Marker marker = null;
    private List<Barrier> barriers = null;  // todo нет поля, поэтому надо откуда-то брать бьрьеры
    private int barriersNumber = 0;

//    PlayerPosition(Marker marker, List<Barrier> barriers) {
//        this.barriers = barriers;
//        this.marker = marker;
//        barriersNumber = barriers.size();
//    }

    public void moveMarker(Coordinates coordinates) throws ItemFieldException {

        marker.moveTo(coordinates.getVertical(), coordinates.getHorizontal());
    }

    public Player createPlayer(Marker marker, List<Barrier> barriers) {
        this.marker = marker;
        this.barriers = barriers;
        barriersNumber = barriers.size();
        return this;
    }

    public void placeBarrier(Coordinates coordinates, BarrierPosition position)
            throws NoBarriersException, ItemFieldException {

        if (barriersNumber == 0) {
            throw new NoBarriersException("you have no barriers");
        }

        barriers.get(barriersNumber - 1).placeBarrier(coordinates.getVertical(), coordinates.getHorizontal(), position);
        barriersNumber--;
    }

    public PlayerInformation getInformation() {

        return new PlayerInformation(barriersNumber, marker.getCoordinates());
    }
}
