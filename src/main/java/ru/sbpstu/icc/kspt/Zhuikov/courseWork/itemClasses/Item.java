package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;

public class Item {

    protected Coordinates coordinates;
    protected Field field = null;

    public Item(Field field) {

        coordinates = new Coordinates(-1, -1);
        this.field = field;

    }

    public Item() {}

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
