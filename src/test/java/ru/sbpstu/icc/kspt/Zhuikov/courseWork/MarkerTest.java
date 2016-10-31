package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.*;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Item;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import static org.junit.Assert.assertEquals;

public class MarkerTest {

    private Field field = new Field();

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testImpossibleCreation() {

        new Marker(field, -4, 2);

    }

    @Test
    public void testMoving() throws ItemFieldException {

        Marker marker = new Marker(field, 0, 4);
        marker.moveTo(2, 4);
        assertEquals(new Coordinates(2, 4), marker.getCoordinates());
        marker.moveTo(2, 2);
        assertEquals(new Coordinates(2, 2), marker.getCoordinates());
        marker.moveTo(0, 2);
        assertEquals(new Coordinates(0, 2), marker.getCoordinates());

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMovingOutOfBounds() throws ItemFieldException {

        Marker marker = new Marker(field, 0, 8);
        marker.moveTo(-2, 8);

    }

    @Test(expected = TooLongDistanceException.class)
    public void testFarMoving() throws ItemFieldException {

        Marker marker = new Marker(field, 4, 4);
        marker.moveTo(6, 6);

    }

    @Test(expected = ImpossibleToSetException.class)
    public void testMoveToWhiteCell() throws ItemFieldException {

        Marker marker = new Marker(field, 10, 10);
        marker.moveTo(10, 11);

    }

    @Test(expected = CellIsNotEmptyException.class)
    public void testMovingToMarkerCell() throws ItemFieldException {

        Marker marker1 = new Marker(field, 0, 8);
        new Marker(field, 2, 8);

        marker1.moveTo(2, 8);

    }

    @Test(expected = SetToSameCellException.class)
    public void testMovingToSameCell() throws ItemFieldException {

        Marker marker = new Marker(field, 0, 8);
        marker.moveTo(0, 8);

    }

}
