package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.FieldItem;

public class Barrier extends Item {

    Barrier(int vertical, int horizontal, Field field) {
        super(vertical, horizontal, field);
    }

    public void toField(int vertical_, int horizontal_, String position) { //todo нечетные коорд.

        field.setItem(FieldItem.BARRIER, vertical_, horizontal_);
        field.setItem(FieldItem.EMPTY, vertical, horizontal);
        vertical = vertical_;
        horizontal = horizontal_;

    }
}
