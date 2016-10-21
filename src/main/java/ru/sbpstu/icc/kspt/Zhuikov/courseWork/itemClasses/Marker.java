package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.FieldItem;

public class Marker extends Item {

    Marker(int vertical, int horizontal, Field field) {
        super(vertical, horizontal, field);
    }

    public void moveTo(int vertical_, int horizontal_) { // todo четные координаты

        field.setItem(FieldItem.MARKER, vertical_, horizontal_);
        field.setItem(FieldItem.EMPTY, vertical, horizontal);
        vertical = vertical_;
        horizontal = horizontal_;

    }
}
