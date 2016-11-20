package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.ItemType;

public class Empty extends Item {

    public Empty(int vertical, int horizontal) {
        type = ItemType.EMPTY;
        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);
    }

}
