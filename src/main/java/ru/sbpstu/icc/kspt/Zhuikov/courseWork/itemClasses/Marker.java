package ru.sbpstu.icc.kspt.Zhuikov.courseWork.itemClasses;

import ru.sbpstu.icc.kspt.Zhuikov.courseWork.Field;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.CellColor;
import ru.sbpstu.icc.kspt.Zhuikov.courseWork.enums.FieldItem;

public class Marker extends Item {   // todo tests

    public Marker(Field field) {
        super(field);
    }

    public Marker(Field field, int vertical_, int horizontal_) {
        field.setItem(FieldItem.MARKER, vertical_, horizontal_);
        this.field = field;
        coordinates.setVertical(vertical_);
        coordinates.setHorizontal(horizontal_);
    }

    public void moveTo(int vertical_, int horizontal_) throws Exception {

        // todo vertical == vertical_ ....!

        checkPlace(vertical_, horizontal_);
        setMarker(vertical_, horizontal_);
    }

    private void checkPlace(int vertical, int horizontal) throws Exception {

        if (field.getColor(vertical, horizontal) == CellColor.WHITE) {
            throw new Exception("impossible to set marker on white cell");
        }

        if ((field.getItem(vertical, horizontal) == FieldItem.MARKER) ||
                (field.getItem(vertical, horizontal) == FieldItem.BARRIER)) {
            throw new Exception("cell " + vertical + horizontal + " is not empty");
        }

        if (Math.sqrt((vertical - coordinates.getVertical()) * (vertical - coordinates.getVertical()) +
                (horizontal - coordinates.getHorizontal()) * (vertical - coordinates.getHorizontal())) > 2.1) {
            throw new Exception("you can move just nearby cells");
        }
    }

    private void setMarker(int vertical, int horizontal) {

        field.setItem(FieldItem.EMPTY, coordinates.getVertical(), coordinates.getHorizontal());
        field.setItem(FieldItem.MARKER, vertical, horizontal);
        coordinates.setVertical(vertical);
        coordinates.setHorizontal(horizontal);
    }
}
