package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;

public class Item {

    protected int vertical = -1;
    protected int horizontal = -1;
    protected Field field;

    public Item(Field field) {

        this.field = field;

    }

    public int getVertical() { return  vertical; }

    public int getHorizontal() { return  horizontal; }

}
