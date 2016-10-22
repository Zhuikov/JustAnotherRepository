package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;

import static org.junit.Assert.assertEquals;

public class BarrierTest {

    private Field field = new Field();
    private Barrier barrier = new Barrier(field);

    @Test
    public void testBarrierSet() {

        barrier.toField(5, 3, "vertical");
        assertEquals(field.getItem(5, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(4, 3), FieldItem.BARRIER);
        assertEquals(field.getItem(6, 3), FieldItem.BARRIER);

    }
}
