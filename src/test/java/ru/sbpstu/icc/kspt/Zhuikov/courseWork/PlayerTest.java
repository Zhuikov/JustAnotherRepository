package ru.sbpstu.icc.kspt.Zhuikov.courseWork;


import org.junit.Test;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.BarrierPosition;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.ItemFieldException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.exceptions.NoBarriersException;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Barrier;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Coordinates;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses.Marker;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Field field = new Field();

    @Test(expected = NoBarriersException.class)
    public void testNoBarriers() throws NoBarriersException, ItemFieldException {

        List<Barrier> barriers = new LinkedList<Barrier>();
        barriers.add(new Barrier(field));
        Player player = Player.TOP.createPlayer(new Marker(field, 0, 8), barriers);

        player.placeBarrier(new Coordinates(11, 11), BarrierPosition.VERTICAL);
        assertEquals(0, player.getInformation().getBarriers());

        player.placeBarrier(new Coordinates(11, 1), BarrierPosition.HORIZONTAL);
    }

}
