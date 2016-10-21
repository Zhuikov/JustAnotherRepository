package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;

public class Item {

    protected int vertical;
    protected int horizontal;
    protected Field field;

    Item(int vertical, int horizontal, Field field) {

        this.vertical = vertical;
        this.horizontal = horizontal;
        this.field = field;

    }

    public int getVertical() { return  vertical; }

    public int getHorizontal() { return  horizontal; }

}
