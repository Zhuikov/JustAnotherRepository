package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Item;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.List;

public class Player { // todo tests

    private Marker marker = null;
    private List<Barrier> barriers = null;  // todo нет поля, поэтому надо откуда-то брать бьрьеры
    private int barriersNumber = 0;

    public Player(Marker marker, List<Barrier> barriers) {
        this.barriers = barriers;
        this.marker = marker;
        barriersNumber = barriers.size();
    }

    public void moveMarker(int vertical, int horizontal) throws ItemFieldException {

        marker.moveTo(vertical, horizontal);
    }

    public void placeBarrier(int vertical, int horizontal, BarrierPosition position)
                throws NoBarriersException, ItemFieldException {

        if (barriersNumber == 0) {
            throw new NoBarriersException("you have no barriers");
        }

        barriers.get(barriersNumber - 1).toField(vertical, horizontal, position);
        barriersNumber--;
    }

    public PlayerInformation getInformation() {

        return new PlayerInformation(barriersNumber, marker.getCoordinates());
    }

}
