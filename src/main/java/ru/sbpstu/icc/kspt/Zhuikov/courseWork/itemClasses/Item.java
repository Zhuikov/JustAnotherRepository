package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.ItemType;

abstract public class Item {

    protected Coordinates coordinates = new Coordinates(0, 0);
    protected Field field = null;
    protected ItemType type = null;

//    public Item(Field field) {
//
//        this.field = field;
//
//    }

    public Item() {}

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ItemType getType() {
        return type;
    }
}
