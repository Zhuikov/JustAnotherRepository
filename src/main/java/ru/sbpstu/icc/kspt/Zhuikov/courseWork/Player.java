package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.List;

public class Player { // todo tests

    // private Field field = null;  // todo надо ли...?
    private Marker marker = null;
    private List<Barrier> barriers = null;

    public Player(Marker marker, List<Barrier> barriers) {
        //this.field = field;
        this.barriers = barriers;
        this.marker = marker;
    }

    public void moveSquare(int vertical, int horizontal) throws Exception {

        if (marker.getCoordinates() == new Coordinates(vertical, horizontal)) {
            throw new Exception("impossible to move to the same cell");
        }
        marker.moveTo(vertical, horizontal);

    }

    public void putBarrier(int vertical, int horizontal, String position) throws Exception {

        if (barriers.isEmpty()) {
            throw new Exception("you have no barriers");
        }
        barriers.get(barriers.size() - 1).toField(vertical, horizontal, position);
        barriers.remove(barriers.size() - 1);

    }
}
