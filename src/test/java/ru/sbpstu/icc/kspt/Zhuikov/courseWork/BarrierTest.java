package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;

import static org.junit.Assert.assertEquals;

public class BarrierTest {

    private Field field = new Field();

    @Test
    public void testVerticalBarrierSet() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(5, 3, "vertical");
        assertEquals(field.getItem(5, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(4, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(6, 3), FieldItem.BARRIER);

    }

    @Test
    public void testHorizontalBarrierSet() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(13, 11, "horizontal");
        assertEquals(field.getItem(13, 10), FieldItem.BARRIER);
        assertEquals(field.getItem(13, 11), FieldItem.BARRIER);
        assertEquals(field.getItem(13, 12), FieldItem.BARRIER);

    }

    @Test
    public void testAllCoordinates() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(11, 5, "vertical");
        assertEquals(barrier.getAllCoordinates().get(0), new Coordinates(10, 5));
        assertEquals(barrier.getAllCoordinates().get(1), new Coordinates(11, 5));
        assertEquals(barrier.getAllCoordinates().get(2), new Coordinates(12, 5));

    }

    @Test(expected = Exception.class)
    public void testBlackCellSet() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(2, 8, "horizontal");

    }

    @Test(expected = Exception.class)
    public void testImpossibleSet() throws Exception {

        Barrier barrier1 = new Barrier(field);
        Barrier barrier2 = new Barrier(field);

        barrier1.toField(5, 3, "vertical");
        barrier2.toField(5, 2, "horizontal");

    }

    @Test(expected = Exception.class)
    public void testSetBetweenBlackCells() throws Exception {

        Barrier barrier = new Barrier(field);
        barrier.toField(7, 12, "vertical");
    }
}
