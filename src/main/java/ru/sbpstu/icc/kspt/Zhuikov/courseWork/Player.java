package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.List;

public class Player { // todo tests

    private Marker marker = null;
    private List<Barrier> barriers = null;

    public Player(Marker marker, List<Barrier> barriers) {
        this.barriers = barriers;
        this.marker = marker;
    }

    public void moveMarker(int vertical, int horizontal) throws ItemFieldException {

        marker.moveTo(vertical, horizontal);

    }

    public void placeBarrier(int vertical, int horizontal, BarrierPosition position)
            throws NoBarriersException, ItemFieldException {

        if (barriers.isEmpty()) {
            throw new NoBarriersException("you have no barriers");
        }
        barriers.get(barriers.size() - 1).toField(vertical, horizontal, position);
        barriers.remove(barriers.size() - 1);

    }

}
