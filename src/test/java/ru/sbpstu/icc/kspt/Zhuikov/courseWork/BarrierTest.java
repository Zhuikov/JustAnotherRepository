package ru.sbpstu.icc.kspt.Zhuikov.courseWork;

import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.FieldItem;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.CellIsNotEmptyException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ImpossibleToSetException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;

import static org.junit.Assert.assertEquals;

public class BarrierTest {

    private Field field = new Field();

    @Test
    public void testVerticalBarrierSet() throws ItemFieldException {

        Barrier barrier = new Barrier(field);
        barrier.toField(5, 3, BarrierPosition.VERTICAL);
        assertEquals(field.getItem(5, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(4, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(6, 3), FieldItem.BARRIER);

    }

    @Test
    public void testHorizontalBarrierSet() throws ItemFieldException {

        Barrier barrier = new Barrier(field);
        barrier.toField(13, 11, BarrierPosition.HORIZONTAL);
        assertEquals(field.getItem(13, 10), FieldItem.BARRIER);
        assertEquals(field.getItem(13, 11), FieldItem.BARRIER);
        assertEquals(field.getItem(13, 12), FieldItem.BARRIER);

    }

    @Test
    public void testAllCoordinates() throws ItemFieldException {

        Barrier barrier = new Barrier(field);
        barrier.toField(11, 5, BarrierPosition.VERTICAL);
        assertEquals(barrier.getAllCoordinates().get(0), new Coordinates(10, 5));
        assertEquals(barrier.getAllCoordinates().get(1), new Coordinates(11, 5));
        assertEquals(barrier.getAllCoordinates().get(2), new Coordinates(12, 5));

    }

    @Test(expected = ImpossibleToSetException.class)
    public void testBlackCellSet() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(2, 8, BarrierPosition.HORIZONTAL);

    }

    @Test(expected = CellIsNotEmptyException.class)
    public void testImpossibleSet() throws Exception {

        Barrier barrier1 = new Barrier(field);
        Barrier barrier2 = new Barrier(field);

        barrier1.toField(5, 3, BarrierPosition.VERTICAL);
        barrier2.toField(5, 2, BarrierPosition.HORIZONTAL);

    }

    @Test(expected = ImpossibleToSetException.class)
    public void testSetBetweenBlackCells() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(7, 12, BarrierPosition.VERTICAL);
    }
}
