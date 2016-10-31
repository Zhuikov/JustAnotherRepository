package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.LinkedList;
import java.util.List;

public class PlayerTest {

    private Field field = new Field();

    @Test(expected = NoBarriersException.class)
    public void testNoBarriers() throws NoBarriersException, ItemFieldException {

        List<Barrier> barriers = new LinkedList<Barrier>();
        barriers.add(new Barrier(field));
        Player player = new Player(new Marker(field, 0, 8), barriers);

        player.placeBarrier(11, 11, BarrierPosition.VERTICAL);

        player.placeBarrier(11, 1, BarrierPosition.HORIZONTAL);
    }

}
