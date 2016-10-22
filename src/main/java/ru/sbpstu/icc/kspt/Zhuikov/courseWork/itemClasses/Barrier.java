package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.FieldItem;

public class Barrier extends Item {

    private final int length = 2;

    public Barrier(Field field) {
        super(field);
    }

    public void toField(int vertical_, int horizontal_, String position) {

        checkArguments(vertical_, horizontal_, position);
        if (checkPlace(vertical_, horizontal_, position)) {
            setBarrier(vertical_, horizontal_, position);
        } else {
            throw new IllegalArgumentException("impossible to place barrier on field " +
                    vertical_ + " " + horizontal_);
        }

        vertical = vertical_;
        horizontal = horizontal_;

    }

    private void checkArguments(int vertical, int horizontal, String position) {

        if (!position.equals("vertical") && !position.equals("horizontal")) {
            throw new IllegalArgumentException("wrong argument \"" + position + "\" in Barrier");
        }
        if ((vertical % 2 == 0) && (horizontal % 2 == 0)) {
            throw new IllegalArgumentException("barrier coordinates can't be even-numbered together");
        }

    }

    private boolean checkPlace(int vertical, int horizontal, String position) {

        if (position.equals("vertical")) {
            for (int i = vertical - length + 1; i < vertical + length - 1; i++) {
                if (field.getItem(i, horizontal) != FieldItem.EMPTY) { //todo ask color
                    return false;
                }
            }

        } else if (position.equals("horizontal")) {
            for (int i = horizontal - length + 1; i < horizontal + length - 1; i++) {
                if (field.getItem(vertical, i) != FieldItem.EMPTY) {  //todo ...
                    return false;
                }
            }
        }

        return true;
    }

    private void setBarrier(int vertical, int horizontal, String position) {

        if (position.equals("vertical")) {
            for (int i = vertical - length + 1; i <= vertical + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, i, horizontal);
            }

        } else if (position.equals("horizontal")) {
            for (int i = horizontal - length + 1; i <= horizontal + length - 1; i++) {
                field.setItem(FieldItem.BARRIER, vertical, i);
            }
        }

    }
}
